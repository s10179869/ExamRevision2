package sg.edu.np.examrevision2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private ArrayList<String> data;
    private Context c;

    public NoteAdapter(Context c, ArrayList<String> data) {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(c).inflate(R.layout.layout_notes,viewGroup,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i)
    {
        noteViewHolder.note.setText(""+data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
