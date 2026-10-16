package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
public interface ColorStyle {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Gradient implements ColorStyle {
        private final /* synthetic */ GradientBrush brush;

        private /* synthetic */ Gradient(GradientBrush gradientBrush) {
            this.brush = gradientBrush;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Gradient m768boximpl(GradientBrush gradientBrush) {
            return new Gradient(gradientBrush);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static GradientBrush m769constructorimpl(GradientBrush brush) {
            Intrinsics.checkNotNullParameter(brush, "brush");
            return brush;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m770equalsimpl(GradientBrush gradientBrush, Object obj) {
            return (obj instanceof Gradient) && Intrinsics.areEqual(gradientBrush, ((Gradient) obj).m774unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m771equalsimpl0(GradientBrush gradientBrush, GradientBrush gradientBrush2) {
            return Intrinsics.areEqual(gradientBrush, gradientBrush2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m772hashCodeimpl(GradientBrush gradientBrush) {
            return gradientBrush.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m773toStringimpl(GradientBrush gradientBrush) {
            return "Gradient(brush=" + gradientBrush + ')';
        }

        public boolean equals(Object obj) {
            return m770equalsimpl(this.brush, obj);
        }

        public final GradientBrush getBrush() {
            return this.brush;
        }

        public int hashCode() {
            return m772hashCodeimpl(this.brush);
        }

        public String toString() {
            return m773toStringimpl(this.brush);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ GradientBrush m774unboximpl() {
            return this.brush;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class Solid implements ColorStyle {
        private final /* synthetic */ long color;

        private /* synthetic */ Solid(long j3) {
            this.color = j3;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Solid m775boximpl(long j3) {
            return new Solid(j3);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m777equalsimpl(long j3, Object obj) {
            return (obj instanceof Solid) && Color.t(j3, ((Solid) obj).m782unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m778equalsimpl0(long j3, long j4) {
            return Color.t(j3, j4);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m779hashCodeimpl(long j3) {
            return Color.z(j3);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m780toStringimpl(long j3) {
            return "Solid(color=" + ((Object) Color.A(j3)) + ')';
        }

        public boolean equals(Object obj) {
            return m777equalsimpl(this.color, obj);
        }

        /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
        public final long m781getColor0d7_KjU() {
            return this.color;
        }

        public int hashCode() {
            return m779hashCodeimpl(this.color);
        }

        public String toString() {
            return m780toStringimpl(this.color);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m782unboximpl() {
            return this.color;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m776constructorimpl(long j3) {
            return j3;
        }
    }
}
