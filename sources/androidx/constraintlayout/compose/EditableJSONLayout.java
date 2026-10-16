package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Registry;
import androidx.constraintlayout.core.state.RegistryCallback;
import kotlin.Metadata;
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
public abstract class EditableJSONLayout implements LayoutInformationReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableState f30556d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f30560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f30561j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30553a = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30554b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MotionLayoutDebugFlags f30555c = MotionLayoutDebugFlags.UNKNOWN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LayoutInfoFlags f30557f = LayoutInfoFlags.NONE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f30558g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f30559h = System.nanoTime();

    public EditableJSONLayout(String str) {
        this.f30561j = str;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public MotionLayoutDebugFlags d() {
        return this.f30555c;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public int g() {
        return this.f30554b;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void i(String str) {
        this.f30559h = System.nanoTime();
        this.f30558g = str;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public LayoutInfoFlags j() {
        return this.f30557f;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public int p() {
        return this.f30553a;
    }

    public final void r(String str) {
        this.f30560i = str;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void s(MutableState mutableState) {
        this.f30556d = mutableState;
    }

    public final String t() {
        return this.f30561j;
    }

    protected final void u() {
        try {
            v(this.f30561j);
            if (this.f30560i != null) {
                Registry.a().b(this.f30560i, new RegistryCallback() { // from class: androidx.constraintlayout.compose.EditableJSONLayout$initialization$callback$1
                });
            }
        } catch (CLParsingException unused) {
        }
    }

    protected void v(String str) {
        CLObject cLObjectM;
        this.f30561j = str;
        try {
            CLObject cLObjectD = CLParser.d(str);
            if (cLObjectD != null) {
                boolean z2 = this.f30560i == null;
                if (z2 && (cLObjectM = cLObjectD.M("Header")) != null) {
                    this.f30560i = cLObjectM.S("exportAs");
                    this.f30557f = LayoutInfoFlags.BOUNDS;
                }
                if (z2) {
                    return;
                }
                w();
            }
        } catch (CLParsingException | Exception unused) {
        }
    }

    protected final void w() {
        MutableState mutableState = this.f30556d;
        if (mutableState != null) {
            Intrinsics.checkNotNull(mutableState);
            MutableState mutableState2 = this.f30556d;
            Intrinsics.checkNotNull(mutableState2);
            mutableState.setValue(Long.valueOf(((Number) mutableState2.getValue()).longValue() + 1));
        }
    }
}
