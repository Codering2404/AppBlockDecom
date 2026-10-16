package cz.mobilesoft.coreblock.scene.insights.usecase;

import android.content.Context;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class MigrateStatisticsToInsightsUseCase extends SuspendUseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f103791c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f103792d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f103793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f103794b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f103795a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return -1639297916;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MigrateStatisticsToInsightsUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f103793a = context;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f103794b = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), qualifier, objArr);
            }
        });
    }

    private final ApplicationDao a() {
        return (ApplicationDao) this.f103794b.getValue();
    }

    private final Map b() {
        BufferedReader bufferedReader;
        Iterator it;
        String lowerCase;
        String lowerCase2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            InputStream inputStreamOpen = this.f103793a.getAssets().open("app_types.csv");
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.f140510b), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                it = TextStreamsKt.e(bufferedReader).iterator();
            } finally {
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
            return linkedHashMap;
        }
        while (true) {
            AppDistractionType appDistractionType = null;
            if (!it.hasNext()) {
                Unit unit = Unit.f139807a;
                CloseableKt.a(bufferedReader, null);
                return linkedHashMap;
            }
            String[] strArr = (String[]) StringsKt.V0((String) it.next(), new String[]{","}, false, 0, 6, null).toArray(new String[0]);
            String str = (String) ArraysKt.getOrNull(strArr, 0);
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            String str2 = (String) ArraysKt.getOrNull(strArr, 1);
            if (str2 != null) {
                lowerCase2 = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            } else {
                lowerCase2 = null;
            }
            Iterator<AppDistractionType> it2 = AppDistractionType.getEntries().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                AppDistractionType next = it2.next();
                AppDistractionType appDistractionType2 = next;
                if (lowerCase2 != null) {
                    String lowerCase3 = appDistractionType2.getParseName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.a0(lowerCase2, lowerCase3, false, 2, null)) {
                        appDistractionType = next;
                        break;
                    }
                }
            }
            AppDistractionType appDistractionType3 = appDistractionType;
            if (lowerCase != null && appDistractionType3 != null) {
                linkedHashMap.put(lowerCase, appDistractionType3);
            }
            e3.printStackTrace();
            CrashHelper.j(e3);
            return linkedHashMap;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:74|75|112|77|78|108|79|80|114|81|82|116|83|(6:86|87|88|101|64|(2:102|(2:104|105)(2:106|107))(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x03fd, code lost:
    
        r0 = r7;
        r7 = r4;
        r4 = r9;
        r9 = r0;
        r1 = r8;
        r8 = r6;
        r6 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03ba, code lost:
    
        r0 = r7;
        r7 = r4;
        r4 = r9;
        r9 = r0;
        r1 = r8;
        r8 = r6;
        r6 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x03c2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03c3, code lost:
    
        r6 = r13;
        r7 = r14;
        r9 = r15;
        r11 = r16;
        r15 = r19;
        r8 = r21;
        r21 = r22;
        r14 = r24;
        r12 = r25;
        r13 = r2;
        r2 = r5;
        r5 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x03d7, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03d8, code lost:
    
        r5 = r6;
        r25 = r8;
        r2 = r9;
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03df, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03e0, code lost:
    
        r5 = r6;
        r25 = r8;
        r2 = r9;
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03e8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03e9, code lost:
    
        r28 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x03fb, code lost:
    
        r13.f140144a = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01dc A[LOOP:1: B:47:0x01d6->B:49:0x01dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0221 A[LOOP:3: B:57:0x021f->B:58:0x0221, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03fb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x039c -> B:87:0x03af). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase.Params r28, kotlin.coroutines.Continuation r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1098
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase.c(cz.mobilesoft.coreblock.scene.insights.usecase.MigrateStatisticsToInsightsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
