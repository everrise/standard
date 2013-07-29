package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.StudentDao;
import jp.co.everrisesample.minimum01.entity.Student;
import jp.co.everrisesample.minimum01.form.StudentDetailForm;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * student detail Page
 *
 */
public class StudentDetailAction extends AbstractAction{

    @ActionForm
    @Resource
    public StudentDetailForm studentDetailForm;

    @Resource
    protected StudentDao studentDao;

    public Student student;

    /**
     *
     * @return
     */
    @Auth
    @Execute(validator = false, urlPattern="{studentId}")
    public String index(){
        long studentId = studentDetailForm.studentIdAsLong();
        this.student = studentDao.findById(studentId);
        if(student == null){
            return "../studentEdit/noStudent.jsp";
        }
        return "index.jsp";
    }
}
