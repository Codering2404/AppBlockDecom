package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import androidx.compose.ui.text.input.TextFieldValue;
import cz.mobilesoft.coreblock.base.ViewEvent;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class StrictModeEmailInputBottomSheetViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismiss extends StrictModeEmailInputBottomSheetViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismiss f121860a = new OnDismiss();

        private OnDismiss() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnDismiss);
        }

        public int hashCode() {
            return 1283093459;
        }

        public String toString() {
            return "OnDismiss";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailChanged extends StrictModeEmailInputBottomSheetViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextFieldValue f121861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailChanged(TextFieldValue email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121861a = email;
        }

        public final TextFieldValue a() {
            return this.f121861a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailChanged) && Intrinsics.areEqual(this.f121861a, ((OnEmailChanged) obj).f121861a);
        }

        public int hashCode() {
            return this.f121861a.hashCode();
        }

        public String toString() {
            return "OnEmailChanged(email=" + this.f121861a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailDoubleChecked extends StrictModeEmailInputBottomSheetViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121862a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailDoubleChecked(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121862a = email;
        }

        public final String a() {
            return this.f121862a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailDoubleChecked) && Intrinsics.areEqual(this.f121862a, ((OnEmailDoubleChecked) obj).f121862a);
        }

        public int hashCode() {
            return this.f121862a.hashCode();
        }

        public String toString() {
            return "OnEmailDoubleChecked(email=" + this.f121862a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailSet extends StrictModeEmailInputBottomSheetViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEmailSet f121863a = new OnEmailSet();

        private OnEmailSet() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEmailSet);
        }

        public int hashCode() {
            return 1600088829;
        }

        public String toString() {
            return "OnEmailSet";
        }
    }

    public /* synthetic */ StrictModeEmailInputBottomSheetViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeEmailInputBottomSheetViewEvent() {
    }
}
