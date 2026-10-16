package ru.noties.markwon.html;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlEmptyTagReplacement {
    public static HtmlEmptyTagReplacement a() {
        return new HtmlEmptyTagReplacement();
    }

    public String b(HtmlTag htmlTag) {
        String strName = htmlTag.name();
        if ("br".equals(strName)) {
            return "\n";
        }
        if (!"img".equals(strName)) {
            return null;
        }
        String str = (String) htmlTag.c().get("alt");
        return (str == null || str.length() == 0) ? "￼" : str;
    }
}
