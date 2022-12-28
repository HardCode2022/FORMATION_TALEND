package routines;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RecupererDate {
		
	  /**
     * getDate : return the current datetime with the given display format format : (optional) string representing the
     * wished format of the date. This string contains fixed strings and variables related to the date. By default, the
     * format string is DD/MM/CCYY. Here is the list of date variables:
     *
     *
     * {talendTypes} String
     *
     * {Category} TalendDate
     *
     * {param} string("CCYY-MM-DD hh:mm:ss") pattern : date pattern + CC for century + YY for year + MM for month + DD
     * for day + hh for hour + mm for minute + ss for second
     *
     * {example} getDate("CCYY-MM-DD hh:mm:ss") #
     */
    public static String getDate(String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        StringBuffer result = new StringBuffer();

        pattern = pattern.replace("CC", "yy"); //$NON-NLS-1$ //$NON-NLS-2$
        pattern = pattern.replace("YY", "yy"); //$NON-NLS-1$ //$NON-NLS-2$
        pattern = pattern.replace("MM", "MM"); //$NON-NLS-1$ //$NON-NLS-2$
        pattern = pattern.replace("DD", "dd"); //$NON-NLS-1$ //$NON-NLS-2$
        pattern = pattern.replace("hh", "HH"); //$NON-NLS-1$ //$NON-NLS-2$

        // not needed
        // pattern.replace("mm", "mm");
        // pattern.replace("ss", "ss");

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.format(Calendar.getInstance().getTime(), result, new FieldPosition(0));
        return result.toString();
    }


  
}
