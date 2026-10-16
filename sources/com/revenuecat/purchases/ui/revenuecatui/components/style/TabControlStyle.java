package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Size;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface TabControlStyle extends ComponentStyle {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Buttons implements TabControlStyle {
        public static final int $stable = 0;
        private final Size size;
        private final StackComponentStyle stack;
        private final boolean visible;

        public Buttons(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
            this.visible = stack.getVisible();
            this.size = stack.getSize();
        }

        public static /* synthetic */ Buttons copy$default(Buttons buttons, StackComponentStyle stackComponentStyle, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                stackComponentStyle = buttons.stack;
            }
            return buttons.copy(stackComponentStyle);
        }

        public final StackComponentStyle component1() {
            return this.stack;
        }

        public final Buttons copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Buttons(stack);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Buttons) && Intrinsics.areEqual(this.stack, ((Buttons) obj).stack);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public Size getSize() {
            return this.size;
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Buttons(stack=" + this.stack + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Toggle implements TabControlStyle {
        public static final int $stable = 0;
        private final Size size;
        private final StackComponentStyle stack;
        private final boolean visible;

        public Toggle(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
            this.visible = stack.getVisible();
            this.size = stack.getSize();
        }

        public static /* synthetic */ Toggle copy$default(Toggle toggle, StackComponentStyle stackComponentStyle, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                stackComponentStyle = toggle.stack;
            }
            return toggle.copy(stackComponentStyle);
        }

        public final StackComponentStyle component1() {
            return this.stack;
        }

        public final Toggle copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Toggle(stack);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Toggle) && Intrinsics.areEqual(this.stack, ((Toggle) obj).stack);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public Size getSize() {
            return this.size;
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Toggle(stack=" + this.stack + ')';
        }
    }
}
