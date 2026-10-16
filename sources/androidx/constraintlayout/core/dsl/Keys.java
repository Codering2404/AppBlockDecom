package androidx.constraintlayout.core.dsl;

import com.revenuecat.purchases.common.Constants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Keys {
    protected void a(StringBuilder sb, String str, float f3) {
        if (Float.isNaN(f3)) {
            return;
        }
        sb.append(str);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(f3);
        sb.append(",\n");
    }

    protected void b(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(str);
            sb.append(":'");
            sb.append(str2);
            sb.append("',\n");
        }
    }

    protected void c(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }

    protected void d(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(e(strArr));
            sb.append(",\n");
        }
    }

    protected String e(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i3 = 0;
        while (i3 < strArr.length) {
            sb.append(i3 == 0 ? "'" : ",'");
            sb.append(strArr[i3]);
            sb.append("'");
            i3++;
        }
        sb.append("]");
        return sb.toString();
    }
}
