package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import cz.mobilesoft.coreblock.base.ViewState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeEmailInputBottomSheetViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldValue f121874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f121875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f121876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f121877d;

    public StrictModeEmailInputBottomSheetViewState(TextFieldValue email, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.f121874a = email;
        this.f121875b = z2;
        this.f121876c = z3;
        this.f121877d = z4;
    }

    public static /* synthetic */ StrictModeEmailInputBottomSheetViewState b(StrictModeEmailInputBottomSheetViewState strictModeEmailInputBottomSheetViewState, TextFieldValue textFieldValue, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            textFieldValue = strictModeEmailInputBottomSheetViewState.f121874a;
        }
        if ((i3 & 2) != 0) {
            z2 = strictModeEmailInputBottomSheetViewState.f121875b;
        }
        if ((i3 & 4) != 0) {
            z3 = strictModeEmailInputBottomSheetViewState.f121876c;
        }
        if ((i3 & 8) != 0) {
            z4 = strictModeEmailInputBottomSheetViewState.f121877d;
        }
        return strictModeEmailInputBottomSheetViewState.a(textFieldValue, z2, z3, z4);
    }

    public final StrictModeEmailInputBottomSheetViewState a(TextFieldValue email, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(email, "email");
        return new StrictModeEmailInputBottomSheetViewState(email, z2, z3, z4);
    }

    public final TextFieldValue c() {
        return this.f121874a;
    }

    public final boolean d() {
        return this.f121877d;
    }

    public final boolean e() {
        return this.f121875b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeEmailInputBottomSheetViewState)) {
            return false;
        }
        StrictModeEmailInputBottomSheetViewState strictModeEmailInputBottomSheetViewState = (StrictModeEmailInputBottomSheetViewState) obj;
        return Intrinsics.areEqual(this.f121874a, strictModeEmailInputBottomSheetViewState.f121874a) && this.f121875b == strictModeEmailInputBottomSheetViewState.f121875b && this.f121876c == strictModeEmailInputBottomSheetViewState.f121876c && this.f121877d == strictModeEmailInputBottomSheetViewState.f121877d;
    }

    public final boolean f() {
        return this.f121876c;
    }

    public int hashCode() {
        return (((((this.f121874a.hashCode() * 31) + Boolean.hashCode(this.f121875b)) * 31) + Boolean.hashCode(this.f121876c)) * 31) + Boolean.hashCode(this.f121877d);
    }

    public String toString() {
        return "StrictModeEmailInputBottomSheetViewState(email=" + this.f121874a + ", isEmailValid=" + this.f121875b + ", isSetEmailVisible=" + this.f121876c + QaXmqxvjHhxVy.YXOebSXdm + this.f121877d + ")";
    }

    public /* synthetic */ StrictModeEmailInputBottomSheetViewState(TextFieldValue textFieldValue, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new TextFieldValue("", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null) : textFieldValue, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? false : z4);
    }
}
