package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

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
public final class DecodeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcel f6519a;

    public DecodeHelper(String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.f6519a = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    private final int a() {
        return this.f6519a.dataAvail();
    }

    private final float b() {
        return BaselineShift.e(e());
    }

    private final byte c() {
        return this.f6519a.readByte();
    }

    private final float e() {
        return this.f6519a.readFloat();
    }

    private final int i() {
        return this.f6519a.readInt();
    }

    private final Shadow j() {
        long jD = d();
        float fE = e();
        return new Shadow(jD, Offset.e((((long) Float.floatToRawIntBits(e())) & 4294967295L) | (Float.floatToRawIntBits(fE) << 32)), e(), null);
    }

    private final String l() {
        return this.f6519a.readString();
    }

    private final TextDecoration m() {
        int i3 = i();
        TextDecoration.Companion companion = TextDecoration.f29625b;
        boolean z2 = (companion.b().e() & i3) != 0;
        boolean z3 = (i3 & companion.d().e()) != 0;
        return (z2 && z3) ? companion.a(CollectionsKt.listOf((Object[]) new TextDecoration[]{companion.b(), companion.d()})) : z2 ? companion.b() : z3 ? companion.d() : companion.c();
    }

    private final TextGeometricTransform n() {
        return new TextGeometricTransform(e(), e());
    }

    private final long p() {
        return ULong.b(this.f6519a.readLong());
    }

    public final long d() {
        return Color.o(p());
    }

    public final int f() {
        byte bC = c();
        return bC == 0 ? FontStyle.f29211b.b() : bC == 1 ? FontStyle.f29211b.a() : FontStyle.f29211b.b();
    }

    public final int g() {
        byte bC = c();
        return bC == 0 ? FontSynthesis.f29215b.b() : bC == 1 ? FontSynthesis.f29215b.a() : bC == 3 ? FontSynthesis.f29215b.c() : bC == 2 ? FontSynthesis.f29215b.d() : FontSynthesis.f29215b.b();
    }

    public final FontWeight h() {
        return new FontWeight(i());
    }

    public final SpanStyle k() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.f6519a.dataAvail() > 1) {
            byte bC = c();
            if (bC != 1) {
                if (bC != 2) {
                    if (bC != 3) {
                        if (bC != 4) {
                            if (bC != 5) {
                                if (bC != 6) {
                                    if (bC != 7) {
                                        if (bC != 8) {
                                            if (bC != 9) {
                                                if (bC != 10) {
                                                    if (bC != 11) {
                                                        if (bC == 12) {
                                                            if (a() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.j(j());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        if (a() < 4) {
                                                            break;
                                                        }
                                                        mutableSpanStyle.k(m());
                                                    }
                                                } else {
                                                    if (a() < 8) {
                                                        break;
                                                    }
                                                    mutableSpanStyle.a(d());
                                                }
                                            } else {
                                                if (a() < 8) {
                                                    break;
                                                }
                                                mutableSpanStyle.l(n());
                                            }
                                        } else {
                                            if (a() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.b(BaselineShift.d(b()));
                                        }
                                    } else {
                                        if (a() < 5) {
                                            break;
                                        }
                                        mutableSpanStyle.i(o());
                                    }
                                } else {
                                    mutableSpanStyle.d(l());
                                }
                            } else {
                                if (a() < 1) {
                                    break;
                                }
                                mutableSpanStyle.g(FontSynthesis.e(g()));
                            }
                        } else {
                            if (a() < 1) {
                                break;
                            }
                            mutableSpanStyle.f(FontStyle.c(f()));
                        }
                    } else {
                        if (a() < 4) {
                            break;
                        }
                        mutableSpanStyle.h(h());
                    }
                } else {
                    if (a() < 5) {
                        break;
                    }
                    mutableSpanStyle.e(o());
                }
            } else {
                if (a() < 8) {
                    break;
                }
                mutableSpanStyle.c(d());
            }
        }
        return mutableSpanStyle.m();
    }

    public final long o() {
        byte bC = c();
        long jB = bC == 1 ? TextUnitType.f30010b.b() : bC == 2 ? TextUnitType.f30010b.a() : TextUnitType.f30010b.c();
        return TextUnitType.g(jB, TextUnitType.f30010b.c()) ? TextUnit.f30006b.a() : TextUnitKt.a(e(), jB);
    }
}
