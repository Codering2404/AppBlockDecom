package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f371b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f372c = LazyKt.b(new Function0<Cleaner>() { // from class: androidx.activity.ImmLeaksCleaner$Companion$cleaner$2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ImmLeaksCleaner.Cleaner invoke() {
            try {
                Field servedViewField = InputMethodManager.class.getDeclaredField("mServedView");
                servedViewField.setAccessible(true);
                Field nextServedViewField = InputMethodManager.class.getDeclaredField("mNextServedView");
                nextServedViewField.setAccessible(true);
                Field hField = InputMethodManager.class.getDeclaredField("mH");
                hField.setAccessible(true);
                Intrinsics.checkNotNullExpressionValue(hField, "hField");
                Intrinsics.checkNotNullExpressionValue(servedViewField, "servedViewField");
                Intrinsics.checkNotNullExpressionValue(nextServedViewField, "nextServedViewField");
                return new ImmLeaksCleaner.ValidCleaner(hField, servedViewField, nextServedViewField);
            } catch (NoSuchFieldException unused) {
                return ImmLeaksCleaner.FailedInitialization.f375a;
            }
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f373a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Cleaner {
        public /* synthetic */ Cleaner(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);

        private Cleaner() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Cleaner a() {
            return (Cleaner) ImmLeaksCleaner.f372c.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FailedInitialization extends Cleaner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FailedInitialization f375a = new FailedInitialization();

        private FailedInitialization() {
            super(null);
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ValidCleaner extends Cleaner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Field f377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Field f378c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidCleaner(Field hField, Field servedViewField, Field nextServedViewField) {
            super(null);
            Intrinsics.checkNotNullParameter(hField, "hField");
            Intrinsics.checkNotNullParameter(servedViewField, "servedViewField");
            Intrinsics.checkNotNullParameter(nextServedViewField, "nextServedViewField");
            this.f376a = hField;
            this.f377b = servedViewField;
            this.f378c = nextServedViewField;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                this.f378c.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                return this.f376a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.checkNotNullParameter(inputMethodManager, "<this>");
            try {
                return (View) this.f377b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void j(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        Object systemService = this.f373a.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        Cleaner cleanerA = f371b.a();
        Object objB = cleanerA.b(inputMethodManager);
        if (objB == null) {
            return;
        }
        synchronized (objB) {
            View viewC = cleanerA.c(inputMethodManager);
            if (viewC == null) {
                return;
            }
            if (viewC.isAttachedToWindow()) {
                return;
            }
            boolean zA = cleanerA.a(inputMethodManager);
            if (zA) {
                inputMethodManager.isActive();
            }
        }
    }
}
