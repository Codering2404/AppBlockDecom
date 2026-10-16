package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class StaticLayoutFactoryDefault implements StaticLayoutFactoryImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f28978a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f28979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor f28980c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Constructor b() {
            if (StaticLayoutFactoryDefault.f28979b) {
                return StaticLayoutFactoryDefault.f28980c;
            }
            StaticLayoutFactoryDefault.f28979b = true;
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                StaticLayoutFactoryDefault.f28980c = StaticLayout.class.getConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            } catch (NoSuchMethodException unused) {
                StaticLayoutFactoryDefault.f28980c = null;
                Log.e("StaticLayoutFactory", "unable to collect necessary constructor.");
            }
            return StaticLayoutFactoryDefault.f28980c;
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout a(StaticLayoutParams staticLayoutParams) {
        Constructor constructorB = f28978a.b();
        StaticLayout staticLayout = null;
        if (constructorB != null) {
            try {
                staticLayout = (StaticLayout) constructorB.newInstance(staticLayoutParams.r(), Integer.valueOf(staticLayoutParams.q()), Integer.valueOf(staticLayoutParams.e()), staticLayoutParams.o(), Integer.valueOf(staticLayoutParams.u()), staticLayoutParams.a(), staticLayoutParams.s(), Float.valueOf(staticLayoutParams.m()), Float.valueOf(staticLayoutParams.l()), Boolean.valueOf(staticLayoutParams.g()), staticLayoutParams.c(), Integer.valueOf(staticLayoutParams.d()), Integer.valueOf(staticLayoutParams.n()));
            } catch (IllegalAccessException unused) {
                f28980c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InstantiationException unused2) {
                f28980c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InvocationTargetException unused3) {
                f28980c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            }
        }
        return staticLayout != null ? staticLayout : new StaticLayout(staticLayoutParams.r(), staticLayoutParams.q(), staticLayoutParams.e(), staticLayoutParams.o(), staticLayoutParams.u(), staticLayoutParams.a(), staticLayoutParams.m(), staticLayoutParams.l(), staticLayoutParams.g(), staticLayoutParams.c(), staticLayoutParams.d());
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    public boolean b(StaticLayout staticLayout, boolean z2) {
        return false;
    }
}
