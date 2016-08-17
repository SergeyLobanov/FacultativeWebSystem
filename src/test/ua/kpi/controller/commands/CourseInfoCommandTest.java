//package test.ua.kpi.controller.commands;
//
//import ua.kpi.controller.commands.CourseInfoCommand;
//import ua.kpi.model.CourseService;
//import ua.kpi.model.entities.Course;
//import ua.kpi.view.AttributeConstant;
//
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.easymock.EasyMock;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import static org.powermock.api.easymock.PowerMock.createMock;
//import static org.powermock.api.easymock.PowerMock.suppressConstructor;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.spy;
//
//import static org.easymock.EasyMock.expect;
//import static org.easymock.EasyMock.replay;
//
//import junit.framework.Assert;
//
///**
// * Test class for CourseInfoCommand class
// *
// * Created by Сергей on 13.08.2016.
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(CourseService.class)
//public class CourseInfoCommandTest {
//	/*
//    @Test
//    public void testExecuteCourseInfo() throws ServletException, IOException {
//    	CourseInfoCommand courseInfoCommand = new CourseInfoCommand();
//
//    	PowerMockito.mockStatic(CourseService.class);
//    	//CourseService courseService = CourseService.getInstance(); //mock(CourseService.class);
//    	//CourseService courseService = createMock(CourseService.class);
//    	CourseService courseService = mock(CourseService.class);
//    	//Course course = mock(Course.class);	    	
//    	HttpServletRequest request = mock(HttpServletRequest.class);
//
//    	//expect(CourseService.getInstance()).andReturn(courseService);
//    	//PowerMock.replay(CourseService.class);
//    	//when(CourseService.getInstance()).thenReturn(courseService); 
//    	
//    	//when(request.getParameter(AttributeConstant.COURSE_ID)).thenReturn("5");
//    	//int courseId = Integer.valueOf(request.getParameter(AttributeConstant.COURSE_ID));
//    	//when(courseService.getCourseById(courseId)).thenReturn(course);
//    	
//    	//doReturn(course).when(courseService).getCourseById(courseId);
//    	
//    	//expect(CourseService.getInstance()).andReturn(courseService);
//
//    	
//    	courseInfoCommand.execute(request, null);
//
//    	//verify(courseService).getCourseById(courseId);
//    	
//    	Course courseAttribute = (Course)request.getAttribute(AttributeConstant.COURSE);
//    	
//    	//Assert.assertEquals(course, courseAttribute);
//    }
//    */
//    @SuppressWarnings("deprecation")
//	@Test
//    public void testExecuteCourseInfoCommand() throws ServletException, IOException {
//    	//Given    	
//    	CourseInfoCommand courseInfoCommand = new CourseInfoCommand();
//    	HttpServletRequest request = mock(HttpServletRequest.class);
//    	HttpServletRequest mockRequest = spy(HttpServletRequest.class);
//    	suppressConstructor(CourseService.class);
//    	PowerMockito.mockStatic(CourseService.class);
//    	//CourseService courseService = createMock(CourseService.class);
//    	CourseService courseService = mock(CourseService.class);
//    	courseInfoCommand.courseService = mock(CourseService.class);
//    	Course course = mock(Course.class);
//    	
//    	//When
//    	//when(request.getParameter(AttributeConstant.COURSE_ID)).thenReturn("5");
//    	//int courseId = Integer.valueOf(request.getParameter(AttributeConstant.COURSE_ID));
//    	when(mockRequest.getParameter(AttributeConstant.COURSE_ID)).thenReturn("5");
//    	int courseId = Integer.valueOf(mockRequest.getParameter(AttributeConstant.COURSE_ID));
//    	BDDMockito.given(CourseService.getInstance()).willReturn(courseService);
//    	//BDDMockito.given(courseService.getCourseById(courseId)).willReturn(course);
//    	when(courseService.getCourseById(courseId)).thenReturn(course);
//    	/*
//    	expect(CourseService.getInstance()).andReturn(courseService);
//    	*/
//    	//expect(courseService.getCourseById(courseId)).andReturn(course);
//    	
//    	//courseInfoCommand.execute(request, null);
//    	courseInfoCommand.execute(mockRequest, null);
//
//    	//Then
//    	
//    	//Course courseAttribute = (Course)request.getAttribute(AttributeConstant.COURSE);
//    	Course courseAttribute = (Course)mockRequest.getAttribute(AttributeConstant.COURSE);
//    	Assert.assertEquals(course, courseAttribute);
//    }
//}
