package cz.mobilesoft.coreblock.view.transformation;

import android.graphics.BitmapFactory;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
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
public final class SvgCapableDecoder implements ResourceDecoder<InputStream, SvgOrBitmapResource> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(InputStream source, int i3, int i4, Options options) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        byte[] bArrC = ByteStreamsKt.c(source);
        try {
            SVG svgL = SVG.l(new ByteArrayInputStream((byte[]) bArrC.clone()));
            if (i3 != Integer.MIN_VALUE) {
                float fH = svgL.h();
                float f3 = i3;
                svgL.A(f3);
                if (i4 == Integer.MIN_VALUE) {
                    svgL.x(svgL.f() * (f3 / fH));
                } else {
                    svgL.x(i4);
                }
            } else if (i4 != Integer.MIN_VALUE) {
                float f4 = svgL.f();
                float f5 = i4;
                svgL.x(f5);
                svgL.A(svgL.h() * (f5 / f4));
            }
            return new SimpleResource(new SvgOrBitmapResource(svgL, null, 2, null));
        } catch (SVGParseException e3) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) bArrC.clone());
            try {
                try {
                    return new SimpleResource(new SvgOrBitmapResource(null, BitmapFactory.decodeStream(byteArrayInputStream), 1, null));
                } catch (Exception unused) {
                    source.close();
                    byteArrayInputStream.close();
                    throw new IOException("Cannot load SVG or Bitmap from stream", e3);
                }
            } catch (IOException unused2) {
                throw new IOException("Cannot load SVG or Bitmap from stream", e3);
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream source, Options options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return true;
    }
}
