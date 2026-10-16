package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.e(th);
        }
    }
}
