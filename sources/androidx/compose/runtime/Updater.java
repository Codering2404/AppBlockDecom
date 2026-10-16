package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Updater<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Composer f24311a;

    public static boolean b(Composer composer, Object obj) {
        return (obj instanceof Updater) && Intrinsics.areEqual(composer, ((Updater) obj).g());
    }

    public static int c(Composer composer) {
        return composer.hashCode();
    }

    public static final void d(Composer composer, final Function1 function1) {
        if (composer.i()) {
            composer.p(Unit.f139807a, new Function2<T, Unit, Unit>() { // from class: androidx.compose.runtime.Updater$init$1
                {
                    super(2);
                }

                public final void c(Object obj, Unit unit) {
                    function1.invoke(obj);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c(obj, (Unit) obj2);
                    return Unit.f139807a;
                }
            });
        }
    }

    public static final void e(Composer composer, Object obj, Function2 function2) {
        if (composer.i() || !Intrinsics.areEqual(composer.G(), obj)) {
            composer.w(obj);
            composer.p(obj, function2);
        }
    }

    public static String f(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    public static final void h(Composer composer, Object obj, Function2 function2) {
        boolean zI = composer.i();
        if (zI || !Intrinsics.areEqual(composer.G(), obj)) {
            composer.w(obj);
            if (zI) {
                return;
            }
            composer.p(obj, function2);
        }
    }

    public boolean equals(Object obj) {
        return b(this.f24311a, obj);
    }

    public final /* synthetic */ Composer g() {
        return this.f24311a;
    }

    public int hashCode() {
        return c(this.f24311a);
    }

    public String toString() {
        return f(this.f24311a);
    }

    public static Composer a(Composer composer) {
        return composer;
    }
}
