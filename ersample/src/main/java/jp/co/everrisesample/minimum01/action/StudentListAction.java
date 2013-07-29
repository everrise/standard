package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.StudentDao;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Student;
import jp.co.everrisesample.minimum01.form.StudentListForm;
import jp.co.everrisesample.minimum01.service.StudentService;

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

    @Execute(validator = false, input="index.jsp")
    public String deleteStudent(){
    	studentService.deleteStudent(studentListForm.a);
    	return "?redirect=true";
    }
}
