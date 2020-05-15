package it.cosenzproject.cmssample.app.service.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.repository.LinkRepository;
import it.cosenzproject.cmssample.app.service.SectionService;
import it.cosenzproject.cmssample.common.entity.Section;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(SectionServiceProvider.BEAN_NAME)
public class SectionServiceProvider extends CRUDServiceImp<Section> implements SectionService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.SectionServiceProvider";

	@Value("${uploadImageFolder}")
	private String basePathImage;

	@Value("${http.image.url}")
	private String httpImageUrl;

	@Autowired
	private LinkRepository linkRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cosenzproject.cmssample.core.service.CRUDServiceImp#saveOrUpdate(it.
	 * cosenzproject.cmssample.core.entity.BaseEntity)
	 */
	@Override
	public Section saveOrUpdate(Section section) {
		Section newSection = section;
		Section s = getOldSection(section.getId());
		mapProperties(newSection, s);
		uploadImage(section, s);
		saveLinks(newSection, s);
		return super.saveOrUpdate(section);
	}

	private void saveLinks(Section newSection, Section s) {
		if (CollectionUtils.isNotEmpty(newSection.getLinks()) && s == null) {
			this.linkRepository.saveAll(newSection.getLinks());
		}
	}

	private void uploadImage(Section section, Section s) {
		if (StringUtils.isNotBlank(section.getUrlLogo()) && s == null) {
			uploadImage(section);
		}
	}

	private void mapProperties(Section newSection, Section s) {
		if (s != null) {
			newSection.setGroup(newSection.getGroup() == null ? s.getGroup() : newSection.getGroup());
			newSection.setName(newSection.getName() == null ? s.getName() : newSection.getName());
			newSection.setLinks(newSection.getLinks() == null ? s.getLinks() : newSection.getLinks());
			newSection.setUrlLogo(newSection.getUrlLogo() == null ? s.getUrlLogo() : newSection.getUrlLogo());
		}
	}

	private Section getOldSection(Integer id) {
		if (id == null) {
			return null;
		}
		return getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cosenzproject.cmssample.core.service.CRUDServiceImp#delete(java.lang.
	 * Integer)
	 */
// Decommentare se non si vuole la logica di cancellazione in cascata
//	@Override
//	public void delete(Integer id) {
//		Section s = getById(id);
//		if (CollectionUtils.isNotEmpty(s.getLinks())) {
//			throw new UnsupportedOperationException("remove links before");
//		}
//		super.delete(id);
//	}

	private void uploadImage(Section section) {
		try {
			String[] imageMetaData = section.getUrlLogo().split("(?=[a-z]*),");
			String[] typeImg = imageMetaData[0].split("data:image\\/");
			writeImage(section, imageMetaData, typeImg[1].split(";")[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeImage(Section section, String[] imageMetaData, String imageExt) throws IOException {
		byte[] imageByte = Base64.getDecoder().decode(imageMetaData[1]);
		String imageName = String.format("%s%d.%s", section.getName(), System.currentTimeMillis(), imageExt);
		Path path = Paths.get(String.format("%s%s", basePathImage, imageName));
		Files.write(path, imageByte);
		section.setUrlLogo(String.format("%s%s", httpImageUrl, imageName));
	}

}
