package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class NotificationCompatJellybean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f33752a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f33753b = new Object();

    static Bundle a(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = action.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.g() : 0);
        bundle.putCharSequence("title", action.h());
        bundle.putParcelable("actionIntent", action.a());
        Bundle bundle2 = action.c() != null ? new Bundle(action.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(action.e()));
        bundle.putBoolean("showsUserInterface", action.g());
        bundle.putInt("semanticAction", action.f());
        return bundle;
    }

    private static Bundle b(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.i());
        bundle.putCharSequence("label", remoteInput.h());
        bundle.putCharSequenceArray("choices", remoteInput.e());
        bundle.putBoolean("allowFreeFormInput", remoteInput.c());
        bundle.putBundle("extras", remoteInput.g());
        Set setD = remoteInput.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i3 = 0; i3 < remoteInputArr.length; i3++) {
            bundleArr[i3] = b(remoteInputArr[i3]);
        }
        return bundleArr;
    }
}
