package it.cosenzproject.cmssample.app.service.provider;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.service.SectionGroupService;
import it.cosenzproject.cmssample.common.entity.Section;
import it.cosenzproject.cmssample.common.entity.SectionGroup;
import it.cosenzproject.cmssample.common.util.Assert;
import it.cosenzproject.cmssample.core.service.CRUDServiceImp;

@Service(SectionGroupServiceProvider.BEAN_NAME)
public class SectionGroupServiceProvider extends CRUDServiceImp<SectionGroup> implements SectionGroupService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.SectionGroupServiceProvider";

	@Autowired
	private SectionServiceProvider sectionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cosenzproject.cmssample.core.service.CRUDServiceImp#saveOrUpdate(it.
	 * cosenzproject.cmssample.core.entity.BaseEntity)
	 */
	@Override
	public SectionGroup saveOrUpdate(SectionGroup t) {
		int sizeColumn = 12;
		if (CollectionUtils.isNotEmpty(t.getSections()) && t.getSections().size() > 1) {
			sizeColumn = sizeColumn / t.getSections().size();
		}
		t.setSizeColumn(sizeColumn);
		super.saveOrUpdate(t);

		Set<Section> sections = t.getSections();
		for (Section section : sections) {
			section.setGroup(t);
			this.sectionService.saveOrUpdate(section);
		}
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cosenzproject.cmssample.core.service.CRUDServiceImp#delete(java.lang.
	 * Integer)
	 */
	@Override
	public void delete(Integer id) {
		SectionGroup sg = getById(id);
		if (CollectionUtils.isNotEmpty(sg.getSections())) {
			throw new UnsupportedOperationException("remove sections before");
		}
		super.delete(id);
	}

	@Override
	public List<Section> getSections(Integer idGroup) {
		SectionGroup group = getById(idGroup);
		Assert.checkResource(group, "SectionGroup not found");
		return group.getSections().stream().collect(Collectors.toList());
	}

}
