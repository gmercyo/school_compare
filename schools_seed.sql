-- This is a very abbreviated seed. Will vastly expand it later, but wanted to test with just a few schools.
DELETE FROM users;

INSERT INTO users (username, auth0_id)
VALUES
('godsmercy37', 'fake'),
('tobi_da_man', 'fake'),
('knowledgeable_lewis', 'fake'),
('highbury_parent_88', 'fake'),
('susie-from-hackney', 'fake'),
('cool_kid_44', 'fake'),
('naughty_kid_72', 'fake'),
('worried_kid_04', 'fake'),
('crazy_kid_69', 'fake'),
('nerdy_kid_22', 'fake'),
('introvert_28', 'fake'),
('friendly_kid_58', 'fake'),
('good_kid_51', 'fake'),
('popular_kid_77', 'fake');

DELETE FROM schools;

INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Ambler Primary School and Children''s Centre',
    'Blackstock Road, N4 2DR',
    -0.101753,
    51.5625992,
    '[{"year": "''24-''25", "radius": 0.290}, {"year": "''23-''24", "radius": 0.393}, {"year": "''22-''23", "radius": 0.289}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50215756',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.amblerprimaryschool.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Gillespie Primary School',
    'Gillespie Road, N5 1LH',
    -0.10007,
    51.5600014,
    '[{"year": "''24-''25", "radius": 0.148}, {"year": "''23-''24", "radius": 0.148}, {"year": "''22-''23", "radius": 0.141}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50235575',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.gillespie.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St John''s Highbury Vale CofE Primary School',
    'Conewood Street, N5 1DL',
    -0.10078,
    51.5582008,
    '[{"year": "''24-''25", "radius": 0.351}, {"year": "''23-''24", "radius": 0.21}, {"year": "''22-''23", "radius": 0.28}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50232508',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://www.stjohnevangelist.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St Joan of Arc RC Primary School',
    'Northolme Road, N5 2UX',
    -0.0970096,
    51.5565987,
    '[{"year": "''24-''25", "radius": 0.55}, {"year": "''23-''24", "radius": 0.33}, {"year": "''22-''23", "radius": 0.2}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50241024',
    'primary',
    'mixed',
    'n/a',
    'catholic',
    'https://www.st-joanofarc.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Quadrant Primary School',
    'Highbury New Park, N5 2DP',
    -0.0918841,
    51.5540009,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    2,
    'https://files.ofsted.gov.uk/v1/file/50228420',
    'primary',
    'mixed',
    'n/a',
    'community',
    'www.highburyquadrantprimary.co.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Elizabeth Garrett Anderson School',
    'Donegal Street, N1 9QG',
    -0.112659,
    51.5330009,
    '[{"year": "''24-''25", "radius": 1.082}, {"year": "''23-''24", "radius": 1.506}, {"year": "''22-''23", "radius": 0.873}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/2447618',
    'secondary',
    'girls',
    'n/a',
    'community',
    'https://www.egaschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Betty Layward Primary School',
    'Clissold Road, N16 9EX',
    -0.0846212,
    51.5578995,
    '[{"year": "''24-''25", "radius": 0.305}, {"year": "''23-''24", "radius": 0.339}, {"year": "''22-''23", "radius": 0.38}, {"year": "''21-''22", "radius": 0.381}, {"year": "''20-''21", "radius": 0.352}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50233922',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.bettylayward.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Grasmere Primary School',
    '92 Albion Road, N16 9PD',
    -0.0835736,
    51.5550003,
    '[{"year": "''24-''25", "radius": 0.331}, {"year": "''23-''24", "radius": 0.297}, {"year": "''22-''23", "radius": 0.417}, {"year": "''21-''22", "radius": 0.38}, {"year": "''20-''21", "radius": 0.3}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50183475',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.grasmere.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Grazebrook Primary School',
    'Lordship Road, N16 0QP',
    -0.0831442,
    51.5642014,
    '[{"year": "''24-''25", "radius": 0.439}, {"year": "''23-''24", "radius": 0.283}, {"year": "''22-''23", "radius": 0.557}, {"year": "''21-''22", "radius": 0.599}, {"year": "''20-''21", "radius": 0.41}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50235291',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.grazebrook.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St. Mary''s Church of England Primary School',
    'Barn Street, N16 0JT',
    -0.0815231,
    51.5623016,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50220293',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://st-marys.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'William Patten Primary School',
    'Stoke Newington Church Street, N16 0NX',
    -0.0749634,
    51.5617981,
    '[{"year": "''24-''25", "radius": 0.422}, {"year": "''23-''24", "radius": 0.365}, {"year": "''22-''23", "radius": 0.207}, {"year": "''21-''22", "radius": 0.475}, {"year": "''20-''21", "radius": 0.227}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50233486',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.williampatten.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Drayton Park Primary School',
    'Arvon Road, N5 1PJ',
    -0.105745,
    51.5516014,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": 0.479}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50134753',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.draytonpark.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Pakeman Primary School',
    'Hornsey Road, N7 6DU',
    -0.114027,
    51.5587997,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50178850',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.pakemanprimary.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Newington Green Primary School',
    'Matthias Road, N16 8NP',
    -0.0834239,
    51.5513992,
    '[{"year": "''24-''25", "radius": 0.431}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50256887',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.newingtongreen.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Canonbury Primary School',
    'Canonbury Road, N1 2UT',
    -0.100568,
    51.544899,
    '[{"year": "''24-''25", "radius": 0.655}, {"year": "''23-''24", "radius": 0.452}, {"year": "''22-''23", "radius": 0.622}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50201204',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://canonburyprimaryschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Parkwood Primary School',
    'Queen''s Drive, N4 2HQ',
    -0.0993251,
    51.5651016,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": 0.94}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": 0.287}, {"year": "''20-''21", "radius": 0.311}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50253328',
    'primary',
    'mixed',
    'n/a',
    'community',
    'http://www.parkwood.hackney.sch.uk');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Sir Thomas Abney Primary School',
    'Fairholt Road, N16 5ED',
    -0.0820873,
    51.5704994,
    '[{"year": "''24-''25", "radius": 2.207}, {"year": "''23-''24", "radius": 1.08}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50093859',
    'primary',
    'mixed',
    'n/a',
    'community',
    'https://www.sirthomasabney.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'St Matthias CofE Primary School',
    'Wordsworth Road, N16 8DD',
    -0.0793649,
    51.5528984,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": -1}, {"year": "''21-''22", "radius": -1}, {"year": "''20-''21", "radius": -1}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50224899',
    'primary',
    'mixed',
    'n/a',
    'coe',
    'https://www.st-matthias.hackney.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Stoke Newington School and Sixth Form',
    'Clissold Road, N16 9EX',
    -0.0846212,
    51.5578995,
    '[{"year": "''24-''25", "radius": 0.797}, {"year": "''23-''24", "radius": 0.911}, {"year": "''22-''23", "radius": 0.9}, {"year": "''21-''22", "radius": 0.603}, {"year": "''20-''21", "radius": 0.747}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50192955',
    'secondary',
    'mixed',
    'n/a',
    'community',
    'http://www.stokenewingtonschool.co.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'Highbury Fields School',
    'Highbury Hill, N5 1AR',
    -0.101539,
    51.5527992,
    '[{"year": "''24-''25", "radius": 0.974}, {"year": "''23-''24", "radius": 0.787}, {"year": "''22-''23", "radius": 0.893}]',
    4,
    'https://files.ofsted.gov.uk/v1/file/50198766',
    'secondary',
    'girls',
    'n/a',
    'community',
    'http://www.highburyfields.islington.sch.uk/');
INSERT INTO schools (name, address, longitude, latitude, catchment_radius, ofsted_rating, ofsted_url, type, gender, sen_availability, religious_affiliation, website)
VALUES (
    'City of London Academy, Highbury Grove',
    '8 Highbury Grove, N5 2EQ',
    -0.098090,
    51.550240,
    '[{"year": "''24-''25", "radius": -1}, {"year": "''23-''24", "radius": -1}, {"year": "''22-''23", "radius": 2.167}]',
    3,
    'https://files.ofsted.gov.uk/v1/file/50186308',
    'secondary',
    'mixed',
    'n/a',
    'community',
    'https://www.highburygrove.cola.org.uk/');



DELETE FROM questions;

INSERT INTO questions (school_id, user_id, content)
VALUES
(1, 1, 'What is the student-to-teacher ratio at this school?'),
(2, 1, 'What extracurricular activities are offered here?'),
(3, 1, 'Is there a school counselor available for students?'),
(4, 1, 'What are the school’s academic performance metrics?'),
(5, 1, 'Are there any upcoming school events or open houses?'),

(5, 2, 'What is the average class size for each grade?'),
(4, 2, 'Does the school offer a gifted and talented program?'),
(3, 2, 'How does the school handle bullying incidents?'),
(2, 2, 'What is the policy on student homework and grading?'),
(1, 2, 'Are there any after-school tutoring programs available?'),

(1, 3, 'What is the school’s approach to inclusive education?'),
(2, 3, 'What is the average SAT score of graduating students?'),
(3, 3, 'How often do parent-teacher meetings occur?'),
(4, 3, 'Are there any programs to support students with special needs?'),
(5, 3, 'What is the school’s attendance policy?'),

(1, 4, 'How does the school incorporate technology into learning?'),
(2, 4, 'What sports programs are available for students?'),
(3, 4, 'What is the school’s policy on student discipline?'),
(4, 4, 'Does the school offer any foreign language courses?'),
(5, 4, 'What is the process for transferring credits from other schools?'),

(5, 5, 'What are the school’s resources for mental health support?'),
(4, 5, 'How does the school prepare students for college applications?'),
(3, 5, 'What career preparation programs are available for students?'),
(2, 5, 'What is the dress code policy at this school?'),
(1, 5, 'How does the school handle field trips and excursions?');

DELETE FROM question_likes;

INSERT INTO question_likes (question_id, user_id)
VALUES
(18, 1),
(18, 2),
(18, 3),
(18, 4),
(18, 5),
(18, 6),
(18, 7),
(18, 8),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(24, 1),
(24, 2),
(24, 3),
(24, 4),
(24, 5),
(24, 6),
(24, 7),
(24, 8),
(24, 9),
(24, 10),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(9, 1),
(9, 2),
(9, 3),
(14, 3),
(14, 4),
(14, 5),
(14, 6),
(14, 7),
(14, 8),
(14, 9),
(19, 1),
(19, 2),
(19, 3),
(19, 4),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(5, 5),
(5, 6),
(5, 7),
(6, 1),
(6, 2),
(6, 3),
(6, 4),
(6, 5),
(6, 6),
(16, 1),
(16, 2),
(16, 3),
(16, 4),
(16, 5),
(16, 6),
(16, 7),
(16, 8),
(16, 9),
(16, 10),
(16, 11),
(11, 1),
(11, 2),
(11, 3),
(11, 4),
(11, 5),
(11, 6),
(11, 7),
(11, 8),
(11, 9),
(11, 10),
(11, 11),
(11, 12),
(1, 1),
(1, 2),
(1, 3),
(1, 4);

DELETE FROM answers;

INSERT INTO answers (school_id, user_id, question_id, content, role)
VALUES
(2, 1, 24, 'There''s a uniform, but children are allowed to dress casually on a couple of days each term.', 'current parent'),
(2, 2, 2, 'There are a bunch of after school clubs, the selection is based on student interests and varies each term. My son''s currently doing science club and drama. They''ll perform at Sadler''s Wells theatre later in the year!', 'my son goes to Gillespie');
