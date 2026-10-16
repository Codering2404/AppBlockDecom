package ru.noties.markwon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import ru.noties.markwon.core.spans.LinkSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkResolverDef implements LinkSpan.Resolver {
    @Override // ru.noties.markwon.core.spans.LinkSpan.Resolver
    public void a(View view, String str) {
        Uri uri = Uri.parse(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w("LinkResolverDef", "Actvity was not found for intent, " + intent.toString());
        }
    }
}
