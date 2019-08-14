package sg.edu.np.examrevision2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView note;
    View v;

    public NoteViewHolder(View v) {
        super(v);
        this.v = v;
        note = v.findViewById(R.id.tvNote);
    }
}
