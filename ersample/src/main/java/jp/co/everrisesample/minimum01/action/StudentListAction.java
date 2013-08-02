package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.StudentDao;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Student;
import jp.co.everrisesample.minimum01.form.StudentListForm;
import jp.co.everrisesample.minimum01.service.StudentService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author Du
 * Student List Page
 *
 */
public class StudentListAction extends AbstractAction{

    @ActionForm
    @Resource
    public StudentListForm studentListForm;

    @Resource
    protected StudentService studentService;

    @Resource
    public StudentDao studentDao;

    public ListForPageDto<Student> pageData;

    /**
     * @author Du
     * @return
     */
    @Auth
    @Execute(validator = false)
    public String index(){
        String name = studentListForm.sw;
        OrderByItem orderByItem = studentListForm.orderColumnAsOrderByItem();
        int limit = 10;
        int page = studentListForm.pageAsInt();
        this.pageData = studentService.searchByNameAndPageConditions(name, orderByItem, limit, page);
        return "index.jsp";
    }

    /**
     * @author Du
     * delete student by studentId
     * @return
     */
    @Execute(validator = false)
    public String deleteStudent(){
    	if((studentListForm.studentId).length > 0){
    		for (int i = 0; i <= (studentListForm.studentId).length - 1; i++){
    			studentService.deleteStudent(Long.parseLong(studentListForm.studentId[i]));
    		}
    	}else{
    		ActionMessages errors = new ActionMessages();
    		errors.add("message", new ActionMessage("errors.delete"));
    		return "index.jsp";
    	}
    	return "?redirect=true";
    }
}
