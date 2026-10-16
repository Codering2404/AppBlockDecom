package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public interface Composer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f23746a = Companion.f23747a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f23747a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Object f23748b = new Object() { // from class: androidx.compose.runtime.Composer$Companion$Empty$1
            public String toString() {
                return "Empty";
            }
        };

        private Companion() {
        }

        public final Object a() {
            return f23748b;
        }
    }

    void A(MovableContent movableContent, Object obj);

    void B(Function0 function0);

    void C();

    RecomposeScope D();

    void E();

    void F(int i3);

    Object G();

    CompositionData H();

    default boolean I(Object obj) {
        return Z(obj);
    }

    void J();

    void K(int i3, Object obj);

    void L();

    void M();

    void N(ProvidedValue providedValue);

    void O(int i3, Object obj);

    void P(Function0 function0);

    void Q();

    void R();

    boolean S();

    void T(RecomposeScope recomposeScope);

    void U();

    int V();

    CompositionContext W();

    void X();

    void Y();

    boolean Z(Object obj);

    int a();

    void a0(int i3);

    default boolean b(boolean z2) {
        return b(z2);
    }

    void b0(ProvidedValue[] providedValueArr);

    default boolean c(float f3) {
        return c(f3);
    }

    void d();

    default boolean e(int i3) {
        return e(i3);
    }

    default boolean f(long j3) {
        return f(j3);
    }

    default boolean g(char c3) {
        return g(c3);
    }

    default boolean h(double d3) {
        return h(d3);
    }

    boolean i();

    void j(boolean z2);

    Composer k(int i3);

    boolean l();

    Applier m();

    ScopeUpdateScope n();

    void o();

    void p(Object obj, Function2 function2);

    Object q(CompositionLocal compositionLocal);

    boolean r(boolean z2, int i3);

    void s(int i3);

    CoroutineContext t();

    CompositionLocalMap u();

    void v();

    void w(Object obj);

    void x();

    void y();

    void z();
}
