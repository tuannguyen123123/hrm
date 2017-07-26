package com.ominext.hrm.constant.common;

/**
 * Created by DUCTOI on 6/9/2017.
 */
public class Constant {

	public static final String ADD_NEW_USER = "add new user";

	public static final String UPDATE_USER = "update user";

	public static final String DELETE_USER = "delete user";
	/** String date format */
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

	/** String date format yyyy-mm-dd */
	public static final String DATE_FORMAT_YYYY_MM_DD = "dd/MM/yyyy";

	/** Controller Status */
	public interface ctrlStatus {

		// Normal
		public static final String NORMAL = "0";

		// Input error
		public static final String ERR_VALIDATE = "1";

		// Permission Denied
		public static final String ERR_WRONG_LOGIN = "2";

		// Permission Denied
		public static final String ERR_PERMISSION_DENIED = "3";

		// Data notfound
		public static final String ERR_DATA_NOT_FOUND = "4";

		// Data existed
		public static final String ERR_DATA_EXISTED = "5";

		// Exception
		public static final String ERR_EXCEPTION = "6";
	}

	/** Type Time Sheet */
	public interface timeSheetType {
		// Late
		public static final String LATE = "0";

		// Day off
		public static final String DAY_OFF = "1";

		// OT
		public static final String OT = "2";
	}

	/** Status Time Sheet */
	public interface timeSheetStatus {

		// Save
		public static final String SAVE = "0";

		// Submit
		public static final String SUBMIT = "1";

		// Approve
		public static final String APPRORE = "2";

		// Reject
		public static final String REJECT = "3";

		// Cancel
		public static final String CANCEL = "4";

	}

}
