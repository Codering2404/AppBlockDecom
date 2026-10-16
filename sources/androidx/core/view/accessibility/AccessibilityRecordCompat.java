package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class AccessibilityRecordCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibilityRecord f34599a;

    public static void a(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollX(i3);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollY(i3);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i3) {
        accessibilityRecord.setSource(view, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f34599a;
        return accessibilityRecord == null ? accessibilityRecordCompat.f34599a == null : accessibilityRecord.equals(accessibilityRecordCompat.f34599a);
    }

    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f34599a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
