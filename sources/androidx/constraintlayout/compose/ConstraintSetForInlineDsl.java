package androidx.constraintlayout.compose;

import android.os.Handler;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ConstraintSetForInlineDsl implements ConstraintSet, RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayoutScope f30509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f30510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SnapshotStateObserver f30511c = new SnapshotStateObserver(new ConstraintSetForInlineDsl$observer$1(this));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30512d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f30513f = new Function1<Unit, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$onCommitAffectingConstrainLambdas$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Unit) obj);
            return Unit.f139807a;
        }

        public final void invoke(Unit unit) {
            this.f30519a.m(true);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f30514g = new ArrayList();

    public ConstraintSetForInlineDsl(ConstraintLayoutScope constraintLayoutScope) {
        this.f30509a = constraintLayoutScope;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void a(final State state, final List list) {
        this.f30514g.clear();
        this.f30511c.p(Unit.f139807a, this.f30513f, new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$applyTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m287invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m287invoke() {
                List list2 = list;
                ConstraintSetForInlineDsl constraintSetForInlineDsl = this;
                int size = list2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Object objP = ((Measurable) list2.get(i3)).p();
                    ConstraintLayoutParentData constraintLayoutParentData = objP instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) objP : null;
                    if (constraintLayoutParentData != null) {
                        ConstrainedLayoutReference constrainedLayoutReferenceB = constraintLayoutParentData.b();
                        constraintLayoutParentData.a().invoke(new ConstrainScope(constrainedLayoutReferenceB.a(), constraintSetForInlineDsl.k().b(constrainedLayoutReferenceB)));
                    }
                    constraintSetForInlineDsl.f30514g.add(constraintLayoutParentData);
                }
                this.k().a(state);
            }
        });
        this.f30512d = false;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean b(List list) {
        if (this.f30512d || list.size() != this.f30514g.size()) {
            return true;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object objP = ((Measurable) list.get(i3)).p();
            if (!Intrinsics.areEqual(objP instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) objP : null, this.f30514g.get(i3))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        this.f30511c.t();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        this.f30511c.u();
        this.f30511c.k();
    }

    public final ConstraintLayoutScope k() {
        return this.f30509a;
    }

    public final void m(boolean z2) {
        this.f30512d = z2;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
    }
}
