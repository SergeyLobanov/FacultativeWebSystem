package ua.kpi.controller.commands;

import ua.kpi.model.FacultativeService;
import ua.kpi.model.entities.CourseMember;
import ua.kpi.view.AttributeConstant;
import ua.kpi.view.LinkConstant;
import ua.kpi.view.MessageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command sets mark and comment for student of course by teacher 
 * Created by Сергей on 30.07.2016.
 */
public class SetMarkCommand implements Command {
    FacultativeService facultativeService = FacultativeService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int mark = Integer.parseInt(request.getParameter(AttributeConstant.MARK));
    	String comment = request.getParameter(AttributeConstant.COMMENT);
    	int index = Integer.parseInt(request.getParameter(AttributeConstant.INDEX));
    	CourseMember courseMember = facultativeService.getCourseMemberById(index);
    	courseMember.setMark(mark);
    	courseMember.setComment(comment);
		request.setAttribute(AttributeConstant.COURSE_MEMBER, courseMember);
    	if (facultativeService.updateMarkAndComment(courseMember)) {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.MARK_UPDATED_SUCCESFULLY);
    	} else {
            request.setAttribute(AttributeConstant.MESSAGE, MessageConstant.INFO_NOT_UPDATED);
    	}
        return LinkConstant.ESTIMATE_STUDENT;
    }
}
