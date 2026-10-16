package androidx.glance.appwidget.action;

import android.content.Context;
import androidx.glance.GlanceId;
import androidx.glance.action.Action;
import androidx.glance.action.ActionParameters;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RunCallbackAction implements Action {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f38555c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f38556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActionParameters f38557b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Context context, String str, GlanceId glanceId, ActionParameters actionParameters, Continuation continuation) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            Class<?> cls = Class.forName(str);
            if (!ActionCallback.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("Provided class must implement ActionCallback.");
            }
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.glance.appwidget.action.ActionCallback");
            Object objA = ((ActionCallback) objNewInstance).a(context, glanceId, actionParameters, continuation);
            return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
        }

        private Companion() {
        }
    }

    public final Class c() {
        return this.f38556a;
    }

    public final ActionParameters getParameters() {
        return this.f38557b;
    }
}
