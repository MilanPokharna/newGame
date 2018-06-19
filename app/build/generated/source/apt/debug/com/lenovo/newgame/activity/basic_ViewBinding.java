// Generated code from Butter Knife. Do not modify!
package com.lenovo.newgame.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lenovo.newgame.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class basic_ViewBinding implements Unbinder {
  private basic target;

  @UiThread
  public basic_ViewBinding(basic target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public basic_ViewBinding(basic target, View source) {
    this.target = target;

    target.textViewLevel = Utils.findRequiredViewAsType(source, R.id.level, "field 'textViewLevel'", TextView.class);
    target.textViewMoves = Utils.findRequiredViewAsType(source, R.id.moves, "field 'textViewMoves'", TextView.class);
    target.textViewGoal = Utils.findRequiredViewAsType(source, R.id.goal, "field 'textViewGoal'", TextView.class);
    target.textViewAnswer = Utils.findRequiredViewAsType(source, R.id.answer, "field 'textViewAnswer'", TextView.class);
    target.settingButton = Utils.findRequiredViewAsType(source, R.id.setting_button, "field 'settingButton'", ImageButton.class);
    target.button8 = Utils.findRequiredViewAsType(source, R.id.button_8, "field 'button8'", Button.class);
    target.button9 = Utils.findRequiredViewAsType(source, R.id.button_9, "field 'button9'", Button.class);
    target.button1 = Utils.findRequiredViewAsType(source, R.id.button_1, "field 'button1'", Button.class);
    target.button2 = Utils.findRequiredViewAsType(source, R.id.button_2, "field 'button2'", Button.class);
    target.buttonClear = Utils.findRequiredViewAsType(source, R.id.button_clear, "field 'buttonClear'", Button.class);
    target.button4 = Utils.findRequiredViewAsType(source, R.id.button_4, "field 'button4'", Button.class);
    target.button5 = Utils.findRequiredViewAsType(source, R.id.button_5, "field 'button5'", Button.class);
    target.button6 = Utils.findRequiredViewAsType(source, R.id.button_6, "field 'button6'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    basic target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewLevel = null;
    target.textViewMoves = null;
    target.textViewGoal = null;
    target.textViewAnswer = null;
    target.settingButton = null;
    target.button8 = null;
    target.button9 = null;
    target.button1 = null;
    target.button2 = null;
    target.buttonClear = null;
    target.button4 = null;
    target.button5 = null;
    target.button6 = null;
  }
}
