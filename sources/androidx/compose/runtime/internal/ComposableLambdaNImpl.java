package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

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
public final class ComposableLambdaNImpl implements ComposableLambdaN {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f24803d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecomposeScope f24804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f24805g;

    private final int c(int i3) {
        int i4 = i3 - 2;
        for (int i5 = 1; i5 * 10 < i4; i5++) {
            i4--;
        }
        return i4;
    }

    private final void d(Composer composer) {
        RecomposeScope recomposeScopeD;
        if (!this.f24801b || (recomposeScopeD = composer.D()) == null) {
            return;
        }
        composer.T(recomposeScopeD);
        if (ComposableLambdaKt.f(this.f24804f, recomposeScopeD)) {
            this.f24804f = recomposeScopeD;
            return;
        }
        List list = this.f24805g;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f24805g = arrayList;
            arrayList.add(recomposeScopeD);
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (ComposableLambdaKt.f((RecomposeScope) list.get(i3), recomposeScopeD)) {
                list.set(i3, recomposeScopeD);
                return;
            }
        }
        list.add(recomposeScopeD);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f24802c;
    }

    @Override // kotlin.jvm.functions.FunctionN
    public Object v(final Object... objArr) {
        final int iC = c(objArr.length);
        Object obj = objArr[iC];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] array = ArraysKt.slice(objArr, RangesKt.B(0, objArr.length - 1)).toArray(new Object[0]);
        Object obj2 = objArr[objArr.length - 1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Composer composerK = ((Composer) obj).k(this.f24800a);
        d(composerK);
        int iD = iIntValue | (composerK.Z(this) ? ComposableLambdaKt.d(iC) : ComposableLambdaKt.g(iC));
        Object obj3 = this.f24803d;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.b(array);
        spreadBuilder.a(Integer.valueOf(iD));
        Object objV = ((FunctionN) obj3).v(spreadBuilder.d(new Object[spreadBuilder.c()]));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaNImpl$invoke$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((Composer) obj4, ((Number) obj5).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer, int i3) {
                    Object[] array2 = ArraysKt.slice(objArr, RangesKt.B(0, iC)).toArray(new Object[0]);
                    Object obj4 = objArr[iC + 1];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int iA = RecomposeScopeImplKt.a(((Integer) obj4).intValue());
                    int length = (objArr.length - iC) - 2;
                    Object[] objArr2 = new Object[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        Object obj5 = objArr[iC + 2 + i4];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                        objArr2[i4] = Integer.valueOf(RecomposeScopeImplKt.a(((Integer) obj5).intValue()));
                    }
                    ComposableLambdaNImpl composableLambdaNImpl = this;
                    SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
                    spreadBuilder2.b(array2);
                    spreadBuilder2.a(composer);
                    spreadBuilder2.a(Integer.valueOf(iA | 1));
                    spreadBuilder2.b(objArr2);
                    composableLambdaNImpl.v(spreadBuilder2.d(new Object[spreadBuilder2.c()]));
                }
            });
        }
        return objV;
    }
}
