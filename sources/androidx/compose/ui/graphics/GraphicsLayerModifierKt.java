package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class GraphicsLayerModifierKt {
    public static final Modifier a(Modifier modifier, Function1 function1) {
        return modifier.then(new BlockGraphicsLayerElement(function1));
    }

    public static final Modifier b(Modifier modifier, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3) {
        return modifier.then(new GraphicsLayerElement(f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, j3, shape, z2, renderEffect, j4, j5, i3, null));
    }

    public static /* synthetic */ Modifier c(Modifier modifier, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, long j3, Shape shape, boolean z2, RenderEffect renderEffect, long j4, long j5, int i3, int i4, Object obj) {
        return b(modifier, (i4 & 1) != 0 ? 1.0f : f3, (i4 & 2) != 0 ? 1.0f : f4, (i4 & 4) == 0 ? f5 : 1.0f, (i4 & 8) != 0 ? 0.0f : f6, (i4 & 16) != 0 ? 0.0f : f7, (i4 & 32) != 0 ? 0.0f : f8, (i4 & 64) != 0 ? 0.0f : f9, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0.0f : f10, (i4 & Function.MAX_NARGS) == 0 ? f11 : 0.0f, (i4 & 512) != 0 ? 8.0f : f12, (i4 & 1024) != 0 ? TransformOrigin.f25955b.a() : j3, (i4 & 2048) != 0 ? RectangleShapeKt.a() : shape, (i4 & 4096) != 0 ? false : z2, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : renderEffect, (i4 & 16384) != 0 ? GraphicsLayerScopeKt.a() : j4, (32768 & i4) != 0 ? GraphicsLayerScopeKt.a() : j5, (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? CompositingStrategy.f25737b.a() : i3);
    }

    public static final Modifier d(Modifier modifier) {
        return InspectableValueKt.b() ? modifier.then(c(Modifier.b8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : modifier;
    }
}
