package ua.kpi.controller.commands;

/**
 * Enumeration of commands with corresponding actions
 * 
 * Created by Сергей on 28.07.2016.
 */
public enum CommandList {
    LOG_IN(new LogInCommand()),
    COURSE_LIST(new CourseListCommand()),
	MY_PROFILE_STUDENT(new StudentProfileCommand()),
	MY_PROFILE_TEACHER(new TeacherProfileCommand()),
    COURSE_INFO(new CourseInfoCommand()),
    JOIN_COURSE(new JoinCourseCommand()),
    ESTIMATE_STUDENT(new EstimateCommand()),
    SET_MARK(new SetMarkCommand());

    /**
     * command value
     */
    private Command command;

    /**
     * command constructor
     */
    private CommandList(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
