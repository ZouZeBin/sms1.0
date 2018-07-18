package com.briup.app02.dao.extend;
import com.briup.app02.vm.SurveyVM;
import java.util.List;
public interface SurveyVMMapper {

	List<SurveyVM> findAllSurveyVM();
	
	SurveyVM findByIdSurveyVM(long id);
}
