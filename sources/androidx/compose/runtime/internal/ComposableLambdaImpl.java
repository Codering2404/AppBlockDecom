package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class ComposableLambdaImpl implements ComposableLambda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RecomposeScope f24582d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f24583f;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<Composer, Integer, Unit> {
        AnonymousClass1(Object obj) {
            super(2, obj, ComposableLambdaImpl.class, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", 8);
        }

        public final void c(Composer composer, int i3) {
            ((ComposableLambdaImpl) this.receiver).c(composer, i3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }
    }

    public ComposableLambdaImpl(int i3, boolean z2, Object obj) {
        this.f24579a = i3;
        this.f24580b = z2;
        this.f24581c = obj;
    }

    private final void N(Composer composer) {
        RecomposeScope recomposeScopeD;
        if (!this.f24580b || (recomposeScopeD = composer.D()) == null) {
            return;
        }
        composer.T(recomposeScopeD);
        if (ComposableLambdaKt.f(this.f24582d, recomposeScopeD)) {
            this.f24582d = recomposeScopeD;
            return;
        }
        List list = this.f24583f;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.f24583f = arrayList;
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

    private final void O() {
        if (this.f24580b) {
            RecomposeScope recomposeScope = this.f24582d;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.f24582d = null;
            }
            List list = this.f24583f;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RecomposeScope) list.get(i3)).invalidate();
                }
                list.clear();
            }
        }
    }

    public Object A(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(11) : ComposableLambdaKt.g(11);
        Object obj12 = this.f24581c;
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Function14<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objL = ((Function14) TypeIntrinsics.f(obj12, 14)).l(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return objL;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                invoke((Composer) obj13, ((Number) obj14).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i5) {
                ComposableLambdaImpl.this.A(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
            }
        });
        return objL;
    }

    @Override // kotlin.jvm.functions.Function16
    public /* bridge */ /* synthetic */ Object B(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return H(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, (Composer) obj14, ((Number) obj15).intValue(), ((Number) obj16).intValue());
    }

    @Override // kotlin.jvm.functions.Function9
    public /* bridge */ /* synthetic */ Object C(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return u(obj, obj2, obj3, obj4, obj5, obj6, obj7, (Composer) obj8, ((Number) obj9).intValue());
    }

    @Override // kotlin.jvm.functions.Function21
    public /* bridge */ /* synthetic */ Object D(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return M(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, (Composer) obj19, ((Number) obj20).intValue(), ((Number) obj21).intValue());
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ Object F(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return x(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, (Composer) obj9, ((Number) obj10).intValue());
    }

    public Object G(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(12) : ComposableLambdaKt.g(12);
        Object obj13 = this.f24581c;
        Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.Function15<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objR = ((Function15) TypeIntrinsics.f(obj13, 15)).r(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj14, Object obj15) {
                    invoke((Composer) obj14, ((Number) obj15).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.G(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objR;
    }

    public Object H(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(13) : ComposableLambdaKt.g(13);
        Object obj14 = this.f24581c;
        Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type kotlin.Function16<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objB = ((Function16) TypeIntrinsics.f(obj14, 16)).B(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.14
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                    invoke((Composer) obj15, ((Number) obj16).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.H(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objB;
    }

    public Object I(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(14) : ComposableLambdaKt.g(14);
        Object obj15 = this.f24581c;
        Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type kotlin.Function17<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objN = ((Function17) TypeIntrinsics.f(obj15, 17)).n(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.15
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj16, Object obj17) {
                    invoke((Composer) obj16, ((Number) obj17).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.I(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objN;
    }

    public Object J(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, final Object obj15, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(15) : ComposableLambdaKt.g(15);
        Object obj16 = this.f24581c;
        Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type kotlin.Function18<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objS = ((Function18) TypeIntrinsics.f(obj16, 18)).s(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.16
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                    invoke((Composer) obj17, ((Number) obj18).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.J(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objS;
    }

    public Object K(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, final Object obj15, final Object obj16, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(16) : ComposableLambdaKt.g(16);
        Object obj17 = this.f24581c;
        Intrinsics.checkNotNull(obj17, "null cannot be cast to non-null type kotlin.Function19<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objW = ((Function19) TypeIntrinsics.f(obj17, 19)).w(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.17
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj18, Object obj19) {
                    invoke((Composer) obj18, ((Number) obj19).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.K(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objW;
    }

    public Object L(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, final Object obj15, final Object obj16, final Object obj17, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(17) : ComposableLambdaKt.g(17);
        Object obj18 = this.f24581c;
        Intrinsics.checkNotNull(obj18, "null cannot be cast to non-null type kotlin.Function20<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"p17\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objG = ((Function20) TypeIntrinsics.f(obj18, 20)).g(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.18
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj20) {
                    invoke((Composer) obj19, ((Number) obj20).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.L(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objG;
    }

    public Object M(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, final Object obj11, final Object obj12, final Object obj13, final Object obj14, final Object obj15, final Object obj16, final Object obj17, final Object obj18, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(18) : ComposableLambdaKt.g(18);
        Object obj19 = this.f24581c;
        Intrinsics.checkNotNull(obj19, "null cannot be cast to non-null type kotlin.Function21<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"p17\")] kotlin.Any?, @[ParameterName(name = \"p18\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objD = ((Function21) TypeIntrinsics.f(obj19, 21)).D(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.19
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj20, Object obj21) {
                    invoke((Composer) obj20, ((Number) obj21).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl.this.M(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, composer2, RecomposeScopeImplKt.a(i3) | 1, RecomposeScopeImplKt.a(i4));
                }
            });
        }
        return objD;
    }

    public final void P(Object obj) {
        if (Intrinsics.areEqual(this.f24581c, obj)) {
            return;
        }
        boolean z2 = this.f24581c == null;
        this.f24581c = obj;
        if (z2) {
            return;
        }
        O();
    }

    @Override // kotlin.jvm.functions.Function11
    public /* bridge */ /* synthetic */ Object b(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return y(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, (Composer) obj10, ((Number) obj11).intValue());
    }

    public Object c(Composer composer, int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = i3 | (composerK.Z(this) ? ComposableLambdaKt.d(0) : ComposableLambdaKt.g(0));
        Object obj = this.f24581c;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function2) TypeIntrinsics.f(obj, 2)).invoke(composerK, Integer.valueOf(iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new AnonymousClass1(this));
        }
        return objInvoke;
    }

    public Object d(final Object obj, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(1) : ComposableLambdaKt.g(1);
        Object obj2 = this.f24581c;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function3) TypeIntrinsics.f(obj2, 3)).invoke(obj, composerK, Integer.valueOf(iD | i3));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.d(obj, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objInvoke;
    }

    public Object e(final Object obj, final Object obj2, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(2) : ComposableLambdaKt.g(2);
        Object obj3 = this.f24581c;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function4) TypeIntrinsics.f(obj3, 4)).invoke(obj, obj2, composerK, Integer.valueOf(iD | i3));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                    invoke((Composer) obj4, ((Number) obj5).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.e(obj, obj2, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objInvoke;
    }

    @Override // kotlin.jvm.functions.Function8
    public /* bridge */ /* synthetic */ Object f(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return q(obj, obj2, obj3, obj4, obj5, obj6, (Composer) obj7, ((Number) obj8).intValue());
    }

    @Override // kotlin.jvm.functions.Function20
    public /* bridge */ /* synthetic */ Object g(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return L(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, (Composer) obj18, ((Number) obj19).intValue(), ((Number) obj20).intValue());
    }

    public Object h(final Object obj, final Object obj2, final Object obj3, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(3) : ComposableLambdaKt.g(3);
        Object obj4 = this.f24581c;
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objInvoke = ((Function5) TypeIntrinsics.f(obj4, 5)).invoke(obj, obj2, obj3, composerK, Integer.valueOf(iD | i3));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj5, Object obj6) {
                    invoke((Composer) obj5, ((Number) obj6).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.h(obj, obj2, obj3, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objInvoke;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return c((Composer) obj, ((Number) obj2).intValue());
    }

    @Override // kotlin.jvm.functions.Function13
    public /* bridge */ /* synthetic */ Object j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return z(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, (Composer) obj11, ((Number) obj12).intValue(), ((Number) obj13).intValue());
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return m(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
    }

    @Override // kotlin.jvm.functions.Function14
    public /* bridge */ /* synthetic */ Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return A(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, (Composer) obj12, ((Number) obj13).intValue(), ((Number) obj14).intValue());
    }

    public Object m(final Object obj, final Object obj2, final Object obj3, final Object obj4, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(4) : ComposableLambdaKt.g(4);
        Object obj5 = this.f24581c;
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objK = ((Function6) TypeIntrinsics.f(obj5, 6)).k(obj, obj2, obj3, obj4, composerK, Integer.valueOf(iD | i3));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7) {
                    invoke((Composer) obj6, ((Number) obj7).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.m(obj, obj2, obj3, obj4, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objK;
    }

    @Override // kotlin.jvm.functions.Function17
    public /* bridge */ /* synthetic */ Object n(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return I(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, (Composer) obj15, ((Number) obj16).intValue(), ((Number) obj17).intValue());
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Object o(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return p(obj, obj2, obj3, obj4, obj5, (Composer) obj6, ((Number) obj7).intValue());
    }

    public Object p(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(5) : ComposableLambdaKt.g(5);
        Object obj6 = this.f24581c;
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objO = ((Function7) TypeIntrinsics.f(obj6, 7)).o(obj, obj2, obj3, obj4, obj5, composerK, Integer.valueOf(i3 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj7, Object obj8) {
                    invoke((Composer) obj7, ((Number) obj8).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.p(obj, obj2, obj3, obj4, obj5, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objO;
    }

    public Object q(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(6) : ComposableLambdaKt.g(6);
        Object obj7 = this.f24581c;
        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Function8<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objF = ((Function8) TypeIntrinsics.f(obj7, 8)).f(obj, obj2, obj3, obj4, obj5, obj6, composerK, Integer.valueOf(i3 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj8, Object obj9) {
                    invoke((Composer) obj8, ((Number) obj9).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.q(obj, obj2, obj3, obj4, obj5, obj6, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objF;
    }

    @Override // kotlin.jvm.functions.Function15
    public /* bridge */ /* synthetic */ Object r(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return G(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, (Composer) obj13, ((Number) obj14).intValue(), ((Number) obj15).intValue());
    }

    @Override // kotlin.jvm.functions.Function18
    public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return J(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, (Composer) obj16, ((Number) obj17).intValue(), ((Number) obj18).intValue());
    }

    public Object u(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(7) : ComposableLambdaKt.g(7);
        Object obj8 = this.f24581c;
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Function9<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objC = ((Function9) TypeIntrinsics.f(obj8, 9)).C(obj, obj2, obj3, obj4, obj5, obj6, obj7, composerK, Integer.valueOf(i3 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj9, Object obj10) {
                    invoke((Composer) obj9, ((Number) obj10).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.u(obj, obj2, obj3, obj4, obj5, obj6, obj7, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objC;
    }

    @Override // kotlin.jvm.functions.Function19
    public /* bridge */ /* synthetic */ Object w(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return K(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, (Composer) obj17, ((Number) obj18).intValue(), ((Number) obj19).intValue());
    }

    public Object x(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(8) : ComposableLambdaKt.g(8);
        Object obj9 = this.f24581c;
        Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Function10<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objF = ((Function10) TypeIntrinsics.f(obj9, 10)).F(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, composerK, Integer.valueOf(i3 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj10, Object obj11) {
                    invoke((Composer) obj10, ((Number) obj11).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.x(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objF;
    }

    public Object y(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, Composer composer, final int i3) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(9) : ComposableLambdaKt.g(9);
        Object obj10 = this.f24581c;
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Function11<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object objB = ((Function11) TypeIntrinsics.f(obj10, 11)).b(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, composerK, Integer.valueOf(i3 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj11, Object obj12) {
                    invoke((Composer) obj11, ((Number) obj12).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposableLambdaImpl.this.y(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, composer2, RecomposeScopeImplKt.a(i3) | 1);
                }
            });
        }
        return objB;
    }

    public Object z(final Object obj, final Object obj2, final Object obj3, final Object obj4, final Object obj5, final Object obj6, final Object obj7, final Object obj8, final Object obj9, final Object obj10, Composer composer, final int i3, int i4) {
        Composer composerK = composer.k(this.f24579a);
        N(composerK);
        int iD = composerK.Z(this) ? ComposableLambdaKt.d(10) : ComposableLambdaKt.g(10);
        Object obj11 = this.f24581c;
        Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.Function13<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object objJ = ((Function13) TypeIntrinsics.f(obj11, 13)).j(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, composerK, Integer.valueOf(i3), Integer.valueOf(i4 | iD));
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl.invoke.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj12, Object obj13) {
                    invoke((Composer) obj12, ((Number) obj13).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ComposableLambdaImpl composableLambdaImpl = ComposableLambdaImpl.this;
                    Object obj12 = obj;
                    Object obj13 = obj2;
                    Object obj14 = obj3;
                    Object obj15 = obj4;
                    Object obj16 = obj5;
                    Object obj17 = obj6;
                    Object obj18 = obj7;
                    Object obj19 = obj8;
                    Object obj20 = obj9;
                    Object obj21 = obj10;
                    int i6 = i3;
                    composableLambdaImpl.z(obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, composer2, i6 | 1, i6);
                }
            });
        }
        return objJ;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return d(obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return e(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return h(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
    }
}
