package com.facebook.appevents.ml;

import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.stetho.common.Utf8Charset;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Utils {
    private static final String DIR_NAME = "facebook_ml/";
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    @JvmStatic
    public static final File getMlDir() {
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utils.class);
            return null;
        }
    }

    @JvmStatic
    public static final Map<String, MTensor> parseModelWeights(File file) {
        Map<String, MTensor> map;
        Map<String, MTensor> map2 = null;
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int iAvailable = fileInputStream.available();
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                byte[] bArr = new byte[iAvailable];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                if (iAvailable < 4) {
                    return null;
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
                byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                int i3 = byteBufferWrap.getInt();
                int i4 = i3 + 4;
                if (iAvailable < i4) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(bArr, 4, i3, Charsets.f140510b));
                JSONArray jSONArrayNames = jSONObject.names();
                int length = jSONArrayNames.length();
                String[] strArr = new String[length];
                for (int i5 = 0; i5 < length; i5++) {
                    strArr[i5] = jSONArrayNames.getString(i5);
                }
                ArraysKt.sort((Object[]) strArr);
                HashMap map3 = new HashMap();
                int i6 = 0;
                while (i6 < length) {
                    String str = strArr[i6];
                    if (str == null) {
                        map = map2;
                    } else {
                        JSONArray jSONArray = jSONObject.getJSONArray(str);
                        int length2 = jSONArray.length();
                        int[] iArr = new int[length2];
                        int i7 = 1;
                        map = map2;
                        for (int i8 = 0; i8 < length2; i8++) {
                            try {
                                int i9 = jSONArray.getInt(i8);
                                iArr[i8] = i9;
                                i7 *= i9;
                            } catch (Exception unused) {
                                return map;
                            } catch (Throwable th) {
                                th = th;
                                CrashShieldHandler.handleThrowable(th, Utils.class);
                                return map;
                            }
                        }
                        int i10 = i7 * 4;
                        int i11 = i4 + i10;
                        if (i11 > iAvailable) {
                            return map;
                        }
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i4, i10);
                        byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                        MTensor mTensor = new MTensor(iArr);
                        byteBufferWrap2.asFloatBuffer().get(mTensor.getData(), 0, i7);
                        map3.put(str, mTensor);
                        i4 = i11;
                    }
                    i6++;
                    map2 = map;
                }
                return map3;
            } catch (Exception unused2) {
                return map2;
            }
        } catch (Throwable th2) {
            th = th2;
            map = map2;
        }
    }

    public final String normalizeString(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "str");
            int length = str.length() - 1;
            int i3 = 0;
            boolean z2 = false;
            while (i3 <= length) {
                boolean z3 = Intrinsics.compare((int) str.charAt(!z2 ? i3 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i3++;
                } else {
                    z2 = true;
                }
            }
            String strJoin = TextUtils.join(" ", (String[]) new Regex("\\s+").m(str.subSequence(i3, length + 1).toString(), 0).toArray(new String[0]));
            Intrinsics.checkNotNullExpressionValue(strJoin, "join(\" \", strArray)");
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int[] vectorize(String texts, int i3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(texts, "texts");
            int[] iArr = new int[i3];
            String strNormalizeString = normalizeString(texts);
            Charset charsetForName = Charset.forName(Utf8Charset.NAME);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
            byte[] bytes = strNormalizeString.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            for (int i4 = 0; i4 < i3; i4++) {
                if (i4 < bytes.length) {
                    iArr[i4] = bytes[i4] & 255;
                } else {
                    iArr[i4] = 0;
                }
            }
            return iArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
