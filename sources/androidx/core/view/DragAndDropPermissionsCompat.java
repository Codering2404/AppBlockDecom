package androidx.core.view;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DragAndDropPermissionsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DragAndDropPermissions f34408a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static DragAndDropPermissions a(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        this.f34408a = dragAndDropPermissions;
    }

    public static DragAndDropPermissionsCompat a(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsA = Api24Impl.a(activity, dragEvent);
        if (dragAndDropPermissionsA != null) {
            return new DragAndDropPermissionsCompat(dragAndDropPermissionsA);
        }
        return null;
    }
}
