package cz.mobilesoft.coreblock.util.constants;

import java.net.IDN;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class UrlParsing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UrlParsing f128456a = new UrlParsing();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f128457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f128458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f128459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f128460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f128461f;

    static {
        Pattern patternCompile = Pattern.compile("(\\Qr.internet.apps.samsung.com/refer?url=\\E(\\Qhttp%3A%2F%2F\\E)?)?(https?://)?([\\p{L}\\p{N}\\-.]+)(:[0-9]+)?(.*)");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        f128457b = patternCompile;
        Pattern patternCompile2 = Pattern.compile("((.*:)//)?(www\\.)?([\\p{L}\\p{N}\\-]+(\\.[\\p{L}\\p{N}\\-]+)+)(:[0-9]+)?(.*)");
        Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(...)");
        f128458c = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("(https?://)?([\\p{L}\\p{N}\\-]+\\.[\\p{L}\\p{N}\\-.]+)(/\\S*)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile3, "compile(...)");
        f128459d = patternCompile3;
        f128460e = SetsKt.setOf((Object[]) new String[]{":id/title_bar", ":id/googleapp_srp_search_box_text"});
        f128461f = 8;
    }

    private UrlParsing() {
    }

    private final String d(String str) {
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            if (str.charAt(i3) >= 128) {
                try {
                    String ascii = IDN.toASCII(str, 1);
                    Intrinsics.checkNotNull(ascii);
                    return ascii;
                } catch (Exception unused) {
                    return str;
                }
            }
            i3++;
        }
    }

    public final String a(String urlString) {
        String strGroup;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Matcher matcher = f128457b.matcher(urlString);
        if (matcher.find() && (strGroup = matcher.group(4)) != null) {
            return d(strGroup);
        }
        return null;
    }

    public final Pattern b() {
        return f128459d;
    }

    public final boolean c(String str) {
        if (str == null) {
            return true;
        }
        Set set = f128460e;
        if ((set instanceof Collection) && set.isEmpty()) {
            return true;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (StringsKt.E(str, (String) it.next(), false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    public final String e(String input) {
        String strGroup;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = f128458c.matcher(input);
        if (matcher.matches() && (strGroup = matcher.group(4)) != null) {
            String strD = d(strGroup);
            if (!Intrinsics.areEqual(strD, strGroup)) {
                return StringsKt.O0(input, matcher.start(4), matcher.end(4), strD).toString();
            }
        }
        return input;
    }
}
