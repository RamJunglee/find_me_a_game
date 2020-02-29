# find_me_a_game

Object Query Language: JOSQl
We have used JOSQl for searching templateId from local-memory object

DB : Postgres

CREATE TABLE public.template
(
 id serial,
 prize_type smallint,
 format smallint,
 size smallint,
 entry_fee smallint,
 CONSTRAINT template_pkey PRIMARY KEY (id),
 CONSTRAINT template_type_format_size_fee UNIQUE (prize_type, format, entry_fee, size)
)

In-Memory : Redis
Used for selecting tableId by templateId



