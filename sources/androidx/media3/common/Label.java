package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Label {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f40702c = Util.y0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f40703d = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40705b;

    public Label(String str, String str2) {
        this.f40704a = Util.S0(str);
        this.f40705b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Label label = (Label) obj;
            if (Objects.equals(this.f40704a, label.f40704a) && Objects.equals(this.f40705b, label.f40705b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f40705b.hashCode() * 31;
        String str = this.f40704a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
