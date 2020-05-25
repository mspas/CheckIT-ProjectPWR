package com.checkit.response.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.checkit.entity.Lecture;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class LecturerSchedule {
	@Getter
	@Setter
	private Long lecturerId;
	@Getter
	private List<DailySchedule> schedule = new ArrayList<LecturerSchedule.DailySchedule>();

	public LecturerSchedule(Long lecturerId) {

		this.lecturerId = lecturerId;

	}

	// processing data and adds lecturer schedule for all days of week
	// start date - date of first day of the week
	public boolean addDailySchedule(List<Lecture> lectures, Date startDate) {

		// sorting list of lectures by days (Mon, Tue...)
		List<List<LectureEntity>> sortedLectures = this.sortLecturesByDate(lectures);

		// maps Date to localDate to enable adding days to date.
		LocalDate localDate = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

		for (int i = 0; i < 7; i++) {

			DailySchedule dailySchedule = new DailySchedule();
			dailySchedule.setDate(formatDate(localDate.plusDays(i)));
			dailySchedule.setDay(getDayAbbreviation(localDate.plusDays(i)));
			dailySchedule.setLectures(sortedLectures.get(i));
			schedule.add(dailySchedule);

		}

		return true;
	}

	private LectureEntity mapLectureToLectureEntity(Lecture lecture) {

		LectureEntity lectureEntity = new LectureEntity();
		lectureEntity.setCourse(lecture.getCourse().getName());
		lectureEntity.setLecturerName(lecture.getLecturer().getFirstName() + " " + lecture.getLecturer().getLastName());
		lectureEntity.setCode(lecture.getCourse().getCode());
		lectureEntity.setBuilding(lecture.getLectureHall().getBuilding());
		lectureEntity.setRoom(lecture.getLectureHall().getRoom());
		lectureEntity.setTime(this.getTimeFromDate(lecture.getDate()));
		lectureEntity.setDuration(lecture.getDuration());

		return lectureEntity;

	}

	// matches lectures to particular day of week
	private List<List<LectureEntity>> sortLecturesByDate(List<Lecture> lectures) {

		List<List<LectureEntity>> sortedLectures = new ArrayList<List<LectureEntity>>();

		// represents all day of week and stores lectures
		List<LectureEntity> mon = new ArrayList<LectureEntity>();
		List<LectureEntity> tue = new ArrayList<LectureEntity>();
		List<LectureEntity> wed = new ArrayList<LectureEntity>();
		List<LectureEntity> thu = new ArrayList<LectureEntity>();
		List<LectureEntity> fri = new ArrayList<LectureEntity>();
		List<LectureEntity> sat = new ArrayList<LectureEntity>();
		List<LectureEntity> sun = new ArrayList<LectureEntity>();

		for (Lecture lecture : lectures) {

			String day = this.getDayAbbreviation(lecture.getDate());

			LectureEntity lectureEntity = this.mapLectureToLectureEntity(lecture);

			switch (day) {
			case "MON":
				mon.add(lectureEntity);
				break;
			case "TUE":
				tue.add(lectureEntity);
				break;
			case "WED":
				wed.add(lectureEntity);
				break;
			case "THU":
				thu.add(lectureEntity);
				break;
			case "FRI":
				fri.add(lectureEntity);
				break;
			case "SAT":
				sat.add(lectureEntity);
				break;
			case "SUN":
				sun.add(lectureEntity);
				break;

			default:
				break;
			}

		}

		sortedLectures.add(mon);
		sortedLectures.add(tue);
		sortedLectures.add(wed);
		sortedLectures.add(thu);
		sortedLectures.add(fri);
		sortedLectures.add(sat);
		sortedLectures.add(sun);

		return sortedLectures;
	}

	private String formatDate(Date date) {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		return ft.format(date);

	}

	private String formatDate(LocalDate date) {

		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		return dtfDate.format(date);

	}

	private String getDayAbbreviation(Date date) {

		SimpleDateFormat ft = new SimpleDateFormat("E", Locale.ENGLISH);
		String abbr = ft.format(date).toUpperCase().toString().toUpperCase();
		return abbr;

	}

	private String getDayAbbreviation(LocalDate date) {

		DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("E", Locale.ENGLISH);
		return dtfDay.format(date).toUpperCase();

	}

	private String getTimeFromDate(Date date) {

		SimpleDateFormat ft = new SimpleDateFormat("kk:mm");
		return ft.format(date);

	}

	@Data
	private class DailySchedule {

		private String date;
		private String day;
		List<LectureEntity> lectures;

		public DailySchedule() {

		}

	}

	@Data
	private class LectureEntity {

		private String course;
		private String code;
		private String lecturerName;
		private String building;
		private String room;
		private String time;
		private Integer duration;

		public LectureEntity() {

		}

	}

}
