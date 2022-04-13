-- Drop table

-- DROP TABLE public.sml_menu_master;

CREATE TABLE public.sml_menu_master (
	main_menu_id varchar(5) NOT NULL,
	mid_menu_id varchar(5) NOT NULL DEFAULT '00000'::character varying,
	sml_menu_id varchar(5) NOT NULL,
	sml_menu_nm varchar(30) NOT NULL,
	sml_menu_seq varchar(5) NOT NULL,
	menu_id varchar(15) NOT NULL,
	create_id varchar(20) NOT NULL,
	create_dt varchar(16) NOT NULL,
	mod_id varchar(20) NOT NULL,
	mod_dt varchar(16) NOT NULL,
	CONSTRAINT pk_sml_menu_master PRIMARY KEY (main_menu_id, mid_menu_id, sml_menu_id)
);
CREATE UNIQUE INDEX sml_menu_master_x0 ON public.sml_menu_master USING btree (menu_id);
