package it.cosenzproject.cmssample.app.service.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.service.LinkService;
import it.cosenzproject.cmssample.common.entity.Link;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(LinkServiceProvider.BEAN_NAME)
public class LinkServiceProvider extends CRUDServiceImp<Link> implements LinkService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.LinkServiceProvider";

	@Value("${uploadImageFolder}")
	private String basePathImage;

	@Value("${http.image.url}")
	private String httpImageUrl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cosenzproject.cmssample.core.service.CRUDServiceImp#saveOrUpdate(it.
	 * cosenzproject.cmssample.core.entity.BaseEntity)
	 */
	@Override
	public Link saveOrUpdate(Link t) {
		Link newLink = t;
		Link link = getOldLink(t.getId());
		mapProperties(newLink, link);
		uploadImage(newLink, link);
		return super.saveOrUpdate(t);
	}

	/**
	 * 
	 * @param newLink
	 * @param link
	 */
	private void uploadImage(Link newLink, Link link) {
		if (StringUtils.isNotBlank(newLink.getUrlIcon()) && link == null) {
			uploadImage(newLink);
		}
	}

	/**
	 * Maps the properties of the old link to the newlink if its properties are null
	 * 
	 * @param newLink
	 * @param link
	 */
	private void mapProperties(Link newLink, Link link) {
		if (link != null) {
			newLink.setName(newLink.getName() != null ? newLink.getName() : link.getName());
			newLink.setLink(newLink.getLink() != null ? newLink.getLink() : link.getLink());
			newLink.setSections(CollectionUtils.isNotEmpty(newLink.getSections()) ? newLink.getSections() : link.getSections());
			newLink.setUrlIcon(newLink.getUrlIcon() != null ? newLink.getUrlIcon() : link.getUrlIcon());
		}
	}

	private Link getOldLink(Integer id) {
		if (id == null)
			return null;

		return getById(id);
	}

	private void uploadImage(Link newLink) {
		try {
			String[] imageMetaData = newLink.getUrlIcon().split("(?=[a-z]*),");
			String[] typeImg = imageMetaData[0].split("data:image\\/");
			writeImage(newLink, imageMetaData, typeImg[1].split(";")[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeImage(Link newLink, String[] imageMetaData, String imageExt) throws IOException {
		byte[] imageByte = Base64.getDecoder().decode(imageMetaData[1]);
		String imageName = String.format("%s%d.%s", newLink.getName(), System.currentTimeMillis(), imageExt);
		Path path = Paths.get(String.format("%s%s", basePathImage, imageName));
		Files.write(path, imageByte);
		newLink.setUrlIcon(String.format("%s%s", httpImageUrl, imageName));
	}

}
