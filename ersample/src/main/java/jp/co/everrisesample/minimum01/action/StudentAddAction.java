package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.form.StudentAddForm;
import jp.co.everrisesample.minimum01.service.StudentService;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.enums.SaveType;

/**
 * @author Du
 * Student add Page
 *
 */
public class StudentAddAction extends AbstractAction{

    @ActionForm
    @Resource
    public StudentAddForm studentAddForm;
    @Resource
    protected StudentService studentService;

    /**
     * @author Du
     * @return
     */
    @Auth
    @Execute(validator = false, removeActionForm = true)
    public String index(){
        return "index.jsp";
    }

    /**
     * @author Du
     * @return
     */
    @Execute(validator = true, input = "?redirect=true", removeActionForm = true, saveErrors = SaveType.SESSION)
    public String saveStudentAdd(){
        studentService.createStudent(studentAddForm.studentName, studentAddForm.address, studentAddForm.email);
        return "../studentList?redirect=true";
    }
}
