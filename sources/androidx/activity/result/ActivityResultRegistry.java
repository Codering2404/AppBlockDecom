package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class ActivityResultRegistry {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Companion f546h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f547a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f548b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f549c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f550d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient Map f551e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f552f = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f553g = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CallbackAndContract<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActivityResultCallback f554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ActivityResultContract f555b;

        public CallbackAndContract(ActivityResultCallback callback, ActivityResultContract contract) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.f554a = callback;
            this.f555b = contract;
        }

        public final ActivityResultCallback a() {
            return this.f554a;
        }

        public final ActivityResultContract b() {
            return this.f555b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class LifecycleContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lifecycle f556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f557b;

        public LifecycleContainer(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.f556a = lifecycle;
            this.f557b = new ArrayList();
        }

        public final void a(LifecycleEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.f556a.addObserver(observer);
            this.f557b.add(observer);
        }

        public final void b() {
            Iterator it = this.f557b.iterator();
            while (it.hasNext()) {
                this.f556a.removeObserver((LifecycleEventObserver) it.next());
            }
            this.f557b.clear();
        }
    }

    private final void d(int i3, String str) {
        this.f547a.put(Integer.valueOf(i3), str);
        this.f548b.put(str, Integer.valueOf(i3));
    }

    private final void g(String str, int i3, Intent intent, CallbackAndContract callbackAndContract) {
        if ((callbackAndContract != null ? callbackAndContract.a() : null) == null || !this.f550d.contains(str)) {
            this.f552f.remove(str);
            this.f553g.putParcelable(str, new ActivityResult(i3, intent));
        } else {
            callbackAndContract.a().onActivityResult(callbackAndContract.b().parseResult(i3, intent));
            this.f550d.remove(str);
        }
    }

    private final int h() {
        for (Number number : SequencesKt.i(new Function0<Integer>() { // from class: androidx.activity.result.ActivityResultRegistry$generateRandomNumber$1
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(Random.f140182a.j(2147418112) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
        })) {
            if (!this.f547a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ActivityResultRegistry activityResultRegistry, String str, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Lifecycle.Event.ON_START != event) {
            if (Lifecycle.Event.ON_STOP == event) {
                activityResultRegistry.f551e.remove(str);
                return;
            } else {
                if (Lifecycle.Event.ON_DESTROY == event) {
                    activityResultRegistry.p(str);
                    return;
                }
                return;
            }
        }
        activityResultRegistry.f551e.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (activityResultRegistry.f552f.containsKey(str)) {
            Object obj = activityResultRegistry.f552f.get(str);
            activityResultRegistry.f552f.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) BundleCompat.a(activityResultRegistry.f553g, str, ActivityResult.class);
        if (activityResult != null) {
            activityResultRegistry.f553g.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.d(), activityResult.c()));
        }
    }

    private final void o(String str) {
        if (((Integer) this.f548b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final boolean e(int i3, int i4, Intent intent) {
        String str = (String) this.f547a.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        g(str, i4, intent, (CallbackAndContract) this.f551e.get(str));
        return true;
    }

    public final boolean f(int i3, Object obj) {
        String str = (String) this.f547a.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.f551e.get(str);
        if ((callbackAndContract != null ? callbackAndContract.a() : null) == null) {
            this.f553g.remove(str);
            this.f552f.put(str, obj);
            return true;
        }
        ActivityResultCallback activityResultCallbackA = callbackAndContract.a();
        Intrinsics.checkNotNull(activityResultCallbackA, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.f550d.remove(str)) {
            return true;
        }
        activityResultCallbackA.onActivityResult(obj);
        return true;
    }

    public abstract void i(int i3, ActivityResultContract activityResultContract, Object obj, ActivityOptionsCompat activityOptionsCompat);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.f550d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.f553g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = stringArrayList.get(i3);
            if (this.f548b.containsKey(str)) {
                Integer num = (Integer) this.f548b.remove(str);
                if (!this.f553g.containsKey(str)) {
                    TypeIntrinsics.d(this.f547a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(num2, "rcs[i]");
            int iIntValue = num2.intValue();
            String str2 = stringArrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(str2, "keys[i]");
            d(iIntValue, str2);
        }
    }

    public final void k(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f548b.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f548b.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f550d));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.f553g));
    }

    public final ActivityResultLauncher l(final String key, final ActivityResultContract contract, ActivityResultCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        o(key);
        this.f551e.put(key, new CallbackAndContract(callback, contract));
        if (this.f552f.containsKey(key)) {
            Object obj = this.f552f.get(key);
            this.f552f.remove(key);
            callback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) BundleCompat.a(this.f553g, key, ActivityResult.class);
        if (activityResult != null) {
            this.f553g.remove(key);
            callback.onActivityResult(contract.parseResult(activityResult.d(), activityResult.c()));
        }
        return new ActivityResultLauncher<Object>() { // from class: androidx.activity.result.ActivityResultRegistry$register$3
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract a() {
                return contract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void c(Object obj2, ActivityOptionsCompat activityOptionsCompat) throws Exception {
                Object obj3 = this.f562a.f548b.get(key);
                ActivityResultContract activityResultContract = contract;
                if (obj3 != null) {
                    int iIntValue = ((Number) obj3).intValue();
                    this.f562a.f550d.add(key);
                    try {
                        this.f562a.i(iIntValue, contract, obj2, activityOptionsCompat);
                        return;
                    } catch (Exception e3) {
                        this.f562a.f550d.remove(key);
                        throw e3;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void d() {
                this.f562a.p(key);
            }
        };
    }

    public final ActivityResultLauncher m(final String key, LifecycleOwner lifecycleOwner, final ActivityResultContract contract, final ActivityResultCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().b(Lifecycle.State.f39950d)) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        o(key);
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f549c.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.a(new LifecycleEventObserver() { // from class: androidx.activity.result.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ActivityResultRegistry.n(this.f580a, key, callback, contract, lifecycleOwner2, event);
            }
        });
        this.f549c.put(key, lifecycleContainer);
        return new ActivityResultLauncher<Object>() { // from class: androidx.activity.result.ActivityResultRegistry$register$2
            @Override // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract a() {
                return contract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void c(Object obj, ActivityOptionsCompat activityOptionsCompat) throws Exception {
                Object obj2 = this.f559a.f548b.get(key);
                ActivityResultContract activityResultContract = contract;
                if (obj2 != null) {
                    int iIntValue = ((Number) obj2).intValue();
                    this.f559a.f550d.add(key);
                    try {
                        this.f559a.i(iIntValue, contract, obj, activityOptionsCompat);
                        return;
                    } catch (Exception e3) {
                        this.f559a.f550d.remove(key);
                        throw e3;
                    }
                }
                throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void d() {
                this.f559a.p(key);
            }
        };
    }

    public final void p(String key) {
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f550d.contains(key) && (num = (Integer) this.f548b.remove(key)) != null) {
            this.f547a.remove(num);
        }
        this.f551e.remove(key);
        if (this.f552f.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.f552f.get(key));
            this.f552f.remove(key);
        }
        if (this.f553g.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) BundleCompat.a(this.f553g, key, ActivityResult.class)));
            this.f553g.remove(key);
        }
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.f549c.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.b();
            this.f549c.remove(key);
        }
    }
}
