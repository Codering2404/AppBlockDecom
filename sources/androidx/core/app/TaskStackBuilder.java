package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f33818a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f33819b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context context) {
        this.f33819b = context;
    }

    public static TaskStackBuilder f(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder a(Intent intent) {
        this.f33818a.add(intent);
        return this;
    }

    public TaskStackBuilder b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f33819b.getPackageManager());
        }
        if (component != null) {
            e(component);
        }
        a(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskStackBuilder d(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof SupportParentable ? ((SupportParentable) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f33819b.getPackageManager());
            }
            e(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public TaskStackBuilder e(ComponentName componentName) {
        int size = this.f33818a.size();
        try {
            Intent intentB = NavUtils.b(this.f33819b, componentName);
            while (intentB != null) {
                this.f33818a.add(size, intentB);
                intentB = NavUtils.b(this.f33819b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e3);
        }
    }

    public Intent g(int i3) {
        return (Intent) this.f33818a.get(i3);
    }

    public int h() {
        return this.f33818a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.f33818a.iterator();
    }

    public void l() {
        n(null);
    }

    public void n(Bundle bundle) {
        if (this.f33818a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f33818a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ContextCompat.startActivities(this.f33819b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f33819b.startActivity(intent);
    }
}
