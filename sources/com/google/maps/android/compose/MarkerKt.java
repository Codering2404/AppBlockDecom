package com.google.maps.android.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import com.google.android.gms.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class MarkerKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0398 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.google.maps.android.compose.MarkerState r39, float r40, long r41, boolean r43, boolean r44, com.google.android.gms.maps.model.BitmapDescriptor r45, long r46, float r48, java.lang.String r49, java.lang.Object r50, java.lang.String r51, boolean r52, float r53, kotlin.jvm.functions.Function1 r54, kotlin.jvm.functions.Function1 r55, kotlin.jvm.functions.Function1 r56, kotlin.jvm.functions.Function1 r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instruction units count: 943
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.MarkerKt.a(com.google.maps.android.compose.MarkerState, float, long, boolean, boolean, com.google.android.gms.maps.model.BitmapDescriptor, long, float, java.lang.String, java.lang.Object, java.lang.String, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(com.google.maps.android.compose.MarkerState r55, float r56, long r57, boolean r59, boolean r60, com.google.android.gms.maps.model.BitmapDescriptor r61, long r62, float r64, java.lang.String r65, java.lang.Object r66, java.lang.String r67, boolean r68, float r69, kotlin.jvm.functions.Function1 r70, kotlin.jvm.functions.Function1 r71, kotlin.jvm.functions.Function1 r72, kotlin.jvm.functions.Function1 r73, kotlin.jvm.functions.Function3 r74, kotlin.jvm.functions.Function3 r75, androidx.compose.runtime.Composer r76, final int r77, final int r78, final int r79) {
        /*
            Method dump skipped, instruction units count: 1221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.MarkerKt.b(com.google.maps.android.compose.MarkerState, float, long, boolean, boolean, com.google.android.gms.maps.model.BitmapDescriptor, long, float, java.lang.String, java.lang.Object, java.lang.String, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(com.google.maps.android.compose.MarkerState r38, float r39, long r40, boolean r42, boolean r43, com.google.android.gms.maps.model.BitmapDescriptor r44, long r45, float r47, java.lang.String r48, java.lang.Object r49, java.lang.String r50, boolean r51, float r52, kotlin.jvm.functions.Function1 r53, kotlin.jvm.functions.Function1 r54, kotlin.jvm.functions.Function1 r55, kotlin.jvm.functions.Function1 r56, kotlin.jvm.functions.Function3 r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instruction units count: 986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.MarkerKt.c(com.google.maps.android.compose.MarkerState, float, long, boolean, boolean, com.google.android.gms.maps.model.BitmapDescriptor, long, float, java.lang.String, java.lang.Object, java.lang.String, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(com.google.maps.android.compose.MarkerState r39, float r40, long r41, boolean r43, boolean r44, com.google.android.gms.maps.model.BitmapDescriptor r45, long r46, float r48, java.lang.String r49, java.lang.Object r50, java.lang.String r51, boolean r52, float r53, kotlin.jvm.functions.Function1 r54, kotlin.jvm.functions.Function1 r55, kotlin.jvm.functions.Function1 r56, kotlin.jvm.functions.Function1 r57, kotlin.jvm.functions.Function3 r58, androidx.compose.runtime.Composer r59, final int r60, final int r61, final int r62) {
        /*
            Method dump skipped, instruction units count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.MarkerKt.d(com.google.maps.android.compose.MarkerState, float, long, boolean, boolean, com.google.android.gms.maps.model.BitmapDescriptor, long, float, java.lang.String, java.lang.Object, java.lang.String, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final MarkerState f(String str, final LatLng latLng, Composer composer, int i3, int i4) {
        composer.F(-665345564);
        if ((i4 & 1) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i4 & 2) != 0) {
            latLng = new LatLng(0.0d, 0.0d);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-665345564, i3, -1, "com.google.maps.android.compose.rememberMarkerState (Marker.kt:121)");
        }
        MarkerState markerState = (MarkerState) RememberSaveableKt.e(new Object[0], MarkerState.f91142d.a(), str2, new Function0<MarkerState>() { // from class: com.google.maps.android.compose.MarkerKt$rememberMarkerState$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MarkerState invoke() {
                return new MarkerState(latLng);
            }
        }, composer, ((i3 << 6) & 896) | 72, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return markerState;
    }
}
