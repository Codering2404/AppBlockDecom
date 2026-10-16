package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class JSONConstraintSet extends EditableJSONLayout implements DerivedConstraintSet {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ConstraintSet f30586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap f30587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f30588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f30589n;

    public /* synthetic */ JSONConstraintSet(String str, String str2, ConstraintSet constraintSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : constraintSet);
    }

    private final void x(ConstraintSetParser.LayoutVariables layoutVariables) {
        String str = this.f30588m;
        if (str != null) {
            try {
                CLObject cLObjectD = CLParser.d(str);
                int size = cLObjectD.size();
                for (int i3 = 0; i3 < size; i3++) {
                    CLElement cLElementB = cLObjectD.B(i3);
                    Intrinsics.checkNotNull(cLElementB, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                    CLKey cLKey = (CLKey) cLElementB;
                    layoutVariables.g(cLKey.b(), cLKey.d0().h());
                }
            } catch (CLParsingException e3) {
                System.err.println("exception: " + e3);
            }
        }
        for (String str2 : this.f30587l.keySet()) {
            Object obj = this.f30587l.get(str2);
            Intrinsics.checkNotNull(obj);
            layoutVariables.g(str2, ((Number) obj).floatValue());
        }
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean b(List list) {
        return this.f30589n;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public float e() {
        return 0.0f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof JSONConstraintSet) {
            return Intrinsics.areEqual(t(), ((JSONConstraintSet) obj).t());
        }
        return false;
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public ConstraintSet f() {
        return this.f30586k;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void h(androidx.constraintlayout.core.state.Transition transition, int i3) {
        x(new ConstraintSetParser.LayoutVariables());
        ConstraintSetParser.v(t(), transition, i3);
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public void l(State state) {
        ConstraintSetParser.LayoutVariables layoutVariables = new ConstraintSetParser.LayoutVariables();
        x(layoutVariables);
        try {
            ConstraintSetParser.u(t(), state, layoutVariables);
            this.f30589n = false;
        } catch (Exception unused) {
            this.f30589n = true;
        }
    }

    @Override // androidx.constraintlayout.compose.EditableJSONLayout
    protected void v(String str) {
        super.v(str);
        this.f30589n = true;
    }

    public JSONConstraintSet(String str, String str2, ConstraintSet constraintSet) {
        super(str);
        this.f30586k = constraintSet;
        this.f30587l = new HashMap();
        this.f30588m = str2;
        this.f30589n = true;
        u();
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void n() {
    }
}
