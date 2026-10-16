package ru.noties.markwon.movement;

import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import ru.noties.markwon.AbstractMarkwonPlugin;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MovementMethodPlugin extends AbstractMarkwonPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MovementMethod f147389a;

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        textView.setMovementMethod(this.f147389a);
    }
}
