package jp.co.everrisesample.minimum01.form;

public class StudentDetailForm extends AbstractListForm{

    /**
     * student ID
     */
    public String studentId;
    public long studentIdAsLong(){
        return Long.valueOf(this.studentId);
    }
}
