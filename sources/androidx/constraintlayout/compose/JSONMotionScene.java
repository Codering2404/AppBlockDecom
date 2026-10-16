package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.HashMap;
import kotlin.Metadata;

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
public final class JSONMotionScene extends EditableJSONLayout implements MotionScene {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final HashMap f30590k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final HashMap f30591l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f30592m;

    @Override // androidx.constraintlayout.compose.MotionScene
    public ConstraintSet c(String str) {
        String strM = m(str);
        if (strM != null) {
            return ConstraintLayoutKt.e(strM);
        }
        return null;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public float e() {
        return this.f30592m;
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public Transition k(String str) {
        CLObject cLObjectD;
        String strX = x(str);
        if (strX == null) {
            return null;
        }
        try {
            cLObjectD = CLParser.d(strX);
        } catch (CLParsingException e3) {
            Log.e("CML", "Error parsing JSON " + e3);
            cLObjectD = null;
        }
        if (cLObjectD == null) {
            return null;
        }
        return new TransitionImpl(cLObjectD);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String m(String str) {
        return (String) this.f30590k.get(str);
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void n() {
        this.f30592m = Float.NaN;
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void o(String str, String str2) {
        this.f30591l.put(str, str2);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void q(String str, String str2) {
        this.f30590k.put(str, str2);
    }

    @Override // androidx.constraintlayout.compose.EditableJSONLayout
    protected void v(String str) {
        super.v(str);
        try {
            ConstraintSetParser.x(this, str);
        } catch (Exception unused) {
        }
    }

    public String x(String str) {
        return (String) this.f30591l.get(str);
    }
}
