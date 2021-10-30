import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            Genre genre = genreMap.getOrDefault(genres[i], new Genre(genres[i]));
            genre.add(new Music(i, plays[i]));
            genreMap.putIfAbsent(genre.name, genre);
        }

        List<Genre> genreList = new LinkedList<>(genreMap.values());
        genreList.sort(Collections.reverseOrder());

        List<Integer> album = new LinkedList<>();
        for(Genre genre : genreList) {
            PriorityQueue<Music> musics = genre.getMusics();

            // 1번째
            if(!musics.isEmpty())
                album.add(musics.poll().index);

            // 2번째
            if(!musics.isEmpty())
                album.add(musics.poll().index);
        }

        return album.stream().mapToInt(i -> i).toArray();
    }

    static class Genre implements Comparable<Genre> {
        private final String name;
        private int totalPlayPoint = 0;
        private final PriorityQueue<Music> musicQueue = new PriorityQueue<>(Collections.reverseOrder());

        public Genre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void add(Music music) {
            totalPlayPoint += music.getPlayPoint();
            musicQueue.offer(music);
        }

        public int getTotalPlayPoint() {
            return totalPlayPoint;
        }

        public PriorityQueue<Music> getMusics() {
            return musicQueue;
        }

        @Override
        public int compareTo(Genre genre) {
            return Integer.compare(this.totalPlayPoint, genre.getTotalPlayPoint());
        }
    }

    static class Music implements Comparable<Music> {
        private final int index;
        private final int playPoint;

        public Music(int index, int playPoint) {
            this.index = index;
            this.playPoint = playPoint;
        }

        public int getIndex() {
            return index;
        }

        public int getPlayPoint() {
            return playPoint;
        }

        @Override
        public int compareTo(Music m) {
            return Integer.compare(this.playPoint, m.getPlayPoint());
        }
    }
}